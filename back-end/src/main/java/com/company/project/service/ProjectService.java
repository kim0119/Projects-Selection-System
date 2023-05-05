package com.company.project.service;
import com.company.project.core.Result;
import com.company.project.model.Project;
import com.company.project.core.Service;

public interface ProjectService extends Service<Project> {

    Result list(Project project);
}
