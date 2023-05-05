package com.company.project.service.impl;

import com.company.project.core.Result;
import com.company.project.core.ResultCode;
import com.company.project.core.ResultGenerator;
import com.company.project.dao.StudentCourseMapper;
import com.company.project.model.Course;
import com.company.project.model.Project;
import com.company.project.model.StudentCourse;
import com.company.project.model.User;
import com.company.project.service.CourseService;
import com.company.project.service.ProjectService;
import com.company.project.service.StudentCourseService;
import com.company.project.core.AbstractService;
import com.company.project.service.UserService;
import com.company.project.utils.DatetimeUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class StudentCourseServiceImpl extends AbstractService<StudentCourse> implements StudentCourseService {

    @Resource
    private StudentCourseMapper studentCourseMapper;

    @Resource
    private UserService userService;

    @Resource
    private ProjectService projectService;

    @Resource
    private StudentCourseService studentCourseService;

    @Override
    public Result add(StudentCourse studentCourse) {

        Project project = projectService.findByIdAndValidDelete(studentCourse.getProjectId());
        if (null == project){
            return ResultGenerator.genFailResult("项目不存在或者已删除，请重新选择项目");
        }

        Integer rows = studentCourseMapper.getCount(studentCourse);
        if (rows > 0){
            return ResultGenerator.genFailResult("该项目已申请，请勿重复申请");
        }

        Integer countNumber = studentCourseService.getCountByProjectId(project.getId());
        countNumber = countNumber + 1;
        if (Integer.valueOf(project.getMaxNumber()) <= countNumber ){
            return ResultGenerator.genFailResult(ResultCode.STUDENT_COURSE_ERROR,"人数已经超过限制");
        }

        studentCourse.setTeacherId(Long.valueOf(project.getCreatedBy()));

        //增加过期时间
        studentCourse.setOverdueTime(DatetimeUtil.tomorrowSecond());
        save(studentCourse);
        Result result=ResultGenerator.genSuccessResult();
        result.setData(studentCourse);
        return result;
    }

    @Override
    public Result list(StudentCourse studentCourse) {

        if (null == studentCourse){
            studentCourse = new StudentCourse();
        }

        if (studentCourse.getCreatedBy() != null){
            User user = userService.findByIdAndValidDelete(Long.valueOf(studentCourse.getCreatedBy()));
            if (null == user){
                return ResultGenerator.genFailResult(ResultCode.USER_NOT_EXIST,"用户信息不存在[账号可能被停用或删除]");
            }

            //管理员查询全部
            if (0 == user.getRoleId()){
                studentCourse.setCreatedBy(null);
                studentCourse.setTeacherId(null);
            }else if (2 == user.getRoleId()){
                //学生
                studentCourse.setCreatedBy(studentCourse.getCreatedBy());
                studentCourse.setTeacherId(null);
            }else if (1 == user.getRoleId()){
                //教师
                studentCourse.setTeacherId(Long.valueOf(studentCourse.getCreatedBy()));
                studentCourse.setCreatedBy(null);
            }
        }

        PageHelper.startPage(studentCourse.getPage() == null ? 0 : studentCourse.getPage(), studentCourse.getLimit() == null ? 10 : studentCourse.getLimit());
        studentCourse.setIsDelete(false);
        List<StudentCourse> list = studentCourseMapper.list(studentCourse);
        if (list != null && list.size() > 0){
            for (StudentCourse d:list) {
                if (d.getStatus() == 0){
                    //是否过期
                    if (new Date().getTime() > d.getOverdueTime().getTime()){
                        d.setStatus(2);
                        update(d);
                    }
                }
            }
        }
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }

    @Override
    public Integer getCountByProjectId(Long projectId) {
        return studentCourseMapper.getCountByProjectId(projectId);
    }
}
