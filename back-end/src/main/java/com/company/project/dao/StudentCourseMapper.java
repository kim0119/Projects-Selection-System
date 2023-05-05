package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.StudentCourse;

import java.util.List;

public interface StudentCourseMapper extends Mapper<StudentCourse> {

    List<StudentCourse> list(StudentCourse studentCourse);

    Integer getCount(StudentCourse studentCourse);

    Integer getCountByProjectId(Long projectId);
}