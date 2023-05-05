package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Project;
import com.company.project.service.ProjectService;
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
@RequestMapping("/project")
@Api(tags = {"/project"}, description = "项目管理模块")
public class ProjectController extends BaseController{
    @Resource
    private ProjectService projectService;

    @ApiOperation(value = "新增", notes = "新增")
    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    public Result add(@RequestBody Project project) {
        project.setCreatedAt(new Date());
        project.setIsDelete(false);
        project.setCreatedBy(super.getUserId());
        projectService.save(project);
        Result result=ResultGenerator.genSuccessResult();
        result.setData(project);
        return result;
    }

    @ApiOperation(value = "删除", notes = "删除")
    @RequestMapping(value = "/delete", method = {RequestMethod.POST})
    public Result delete(@RequestParam Long id) {
        Project project=new Project();
        project.setId(id);
        project.setIsDelete(true);
        projectService.update(project);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "修改", notes = "修改")
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public Result update(@RequestBody Project project) {
        project.setUpdatedAt(new Date());
        projectService.update(project);
        Result result=ResultGenerator.genSuccessResult();
        result.setData(project);
        return result;
    }

    @ApiOperation(value = "获取单个详情", notes = "获取单个详情")
    @RequestMapping(value = "/detail", method = {RequestMethod.POST})
    public Result detail(@RequestParam(value = "id", required = false) Long id) {
        if (null == id){
            return ResultGenerator.genSuccessResult(new Project());
        }else {
            Project project = projectService.findById(id);
            if (null == project){
                return ResultGenerator.genSuccessResult(new Project());
            }else {
                return ResultGenerator.genSuccessResult(project);
            }
        }
    }

    @ApiOperation(value = "分页查询", notes = "分页查询")
    @RequestMapping(value = "/findByModal", method = {RequestMethod.POST})
    public Result list(@RequestBody(required =false) Project project) {
        return projectService.list(project);
    }
}
