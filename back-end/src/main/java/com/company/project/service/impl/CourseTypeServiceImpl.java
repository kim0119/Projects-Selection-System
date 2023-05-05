package com.company.project.service.impl;

import com.company.project.dao.CourseTypeMapper;
import com.company.project.model.CourseType;
import com.company.project.service.CourseTypeService;
import com.company.project.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
@Transactional
public class CourseTypeServiceImpl extends AbstractService<CourseType> implements CourseTypeService {

    @Resource
    private CourseTypeMapper tCourseTypeMapper;

}
