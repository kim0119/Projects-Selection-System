package com.company.project.service.impl;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.dao.ProjectMapper;
import com.company.project.model.Project;
import com.company.project.service.ProjectService;
import com.company.project.core.AbstractService;
import com.company.project.service.StudentCourseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class ProjectServiceImpl extends AbstractService<Project> implements ProjectService {

    @Resource
    private ProjectMapper projectMapper;

    @Resource
    private StudentCourseService studentCourseService;

    @Override
    public Result list(Project project) {

        if (null == project){
            project = new Project();
        }

        //PageHelper是mybatis的分页插件，利用这个插件来设置开始的页数
        //getPage（）拿到前端的页数进行设置，设置每一页限制的条数
        //设置分页对象
        PageHelper.startPage(project.getPage() == null ? 0 : project.getPage(), project.getLimit() == null ? 10 : project.getLimit());
        project.setIsDelete(false);
        //设置完后通过list去查询整个页面的列表，
        //调用mapper查询数据库，查到所有的信息
        List<Project> list = projectMapper.list(project);
        if (list != null && list.size() > 0){
            for (Project d:list) {
                d.setFrontNumber(studentCourseService.getCountByProjectId(d.getId()).toString());
            }
        }
        //把这个list给到分页对象，分页对象会根据前面的分页规则进行分页，最后返回给前端
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
