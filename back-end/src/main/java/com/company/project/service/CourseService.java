package com.company.project.service;
import com.company.project.core.Result;
import com.company.project.model.Course;
import com.company.project.core.Service;

public interface CourseService extends Service<Course> {

    Result list(Course course);
}
