package com.company.project.service.impl;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.dao.CourseMapper;
import com.company.project.model.Course;
import com.company.project.service.CourseService;
import com.company.project.core.AbstractService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class CourseServiceImpl extends AbstractService<Course> implements CourseService {

    @Resource
    private CourseMapper courseMapper;

    @Override
    public Result list(Course course) {

        if (null == course){
            course = new Course();
        }

        PageHelper.startPage(course.getPage() == null ? 0 : course.getPage(), course.getLimit() == null ? 10 : course.getLimit());
        course.setIsDelete(false);
        List<Course> list = courseMapper.list(course);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
