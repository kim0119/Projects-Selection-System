package com.company.project.dao;

import com.company.project.core.Mapper;
import com.company.project.model.Project;

import java.util.List;

public interface ProjectMapper extends Mapper<Project> {

    List<Project> list(Project project);

}