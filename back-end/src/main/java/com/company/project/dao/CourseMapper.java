package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.Course;

import java.util.List;

public interface CourseMapper extends Mapper<Course> {

    //这种是自己写的，就要自己写sql语句，其他的可直接调用mybatis
    List<Course> list(Course course);

}