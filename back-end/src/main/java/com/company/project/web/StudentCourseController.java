package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.StudentCourse;
import com.company.project.service.StudentCourseService;
import com.company.project.common.BaseController;
import io.swagger.annotations.Api;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;

import javax.annotation.Resource;
import java.util.List;
import java.util.Date;

@RestController
@RequestMapping("/student/course")
@Api(tags = {"/student/course"}, description = "学生选课管理模块")
public class StudentCourseController extends BaseController{
    @Resource
    private StudentCourseService studentCourseService;

    @ApiOperation(value = "新增", notes = "新增")
    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    public Result add(@RequestBody StudentCourse studentCourse) {
        studentCourse.setCreatedAt(new Date());
        studentCourse.setIsDelete(false);
        studentCourse.setCreatedBy(super.getUserId());
        studentCourse.setStatus(0);
        return studentCourseService.add(studentCourse);
    }

    @ApiOperation(value = "删除", notes = "删除")
    @RequestMapping(value = "/delete", method = {RequestMethod.POST})
    public Result delete(@RequestParam Long id) {
        StudentCourse studentCourse=new StudentCourse();
        studentCourse.setId(id);
        studentCourse.setIsDelete(true);
        studentCourseService.update(studentCourse);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "修改", notes = "修改")
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public Result update(@RequestBody StudentCourse studentCourse) {
        studentCourse.setUpdatedAt(new Date());
        studentCourseService.update(studentCourse);
        Result result=ResultGenerator.genSuccessResult();
        result.setData(studentCourse);
        return result;
    }

    @ApiOperation(value = "获取单个详情", notes = "获取单个详情")
    @RequestMapping(value = "/detail", method = {RequestMethod.POST})
    public Result detail(@RequestParam(value = "id", required = false) Long id) {
        if (null == id){
            return ResultGenerator.genSuccessResult(new StudentCourse());
        }else {
            StudentCourse studentCourse = studentCourseService.findById(id);
            if (null == studentCourse){
                return ResultGenerator.genSuccessResult(new StudentCourse());
            }else {
                return ResultGenerator.genSuccessResult(studentCourse);
            }
        }
    }

    @ApiOperation(value = "分页查询", notes = "分页查询")
    @RequestMapping(value = "/findByModal", method = {RequestMethod.POST})
    public Result list(@RequestBody(required =false) StudentCourse studentCourse) {
        studentCourse.setCreatedBy(super.getUserId());
        return studentCourseService.list(studentCourse);
    }
}
