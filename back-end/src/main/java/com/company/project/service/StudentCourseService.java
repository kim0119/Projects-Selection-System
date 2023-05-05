package com.company.project.service;
import com.company.project.core.Result;
import com.company.project.model.StudentCourse;
import com.company.project.core.Service;

public interface StudentCourseService extends Service<StudentCourse> {

    Result list(StudentCourse studentCourse);

    Result add(StudentCourse studentCourse);

    Integer getCountByProjectId(Long projectId);
}
