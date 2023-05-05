package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Classroom;
import com.company.project.service.ClassroomService;
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
@RequestMapping("/classroom")
@Api(tags = {"/classroom"}, description = "教室管理模块")
public class ClassroomController extends BaseController{
    @Resource
    private ClassroomService classroomService;

    @ApiOperation(value = "新增", notes = "新增")
    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    public Result add(@RequestBody Classroom classroom) {
        classroom.setCreatedAt(new Date());
        classroom.setIsDelete(false);
        classroom.setCreatedBy(super.getUserId());
        classroomService.save(classroom);
        Result result=ResultGenerator.genSuccessResult();
        result.setData(classroom);
        return result;
    }

    @ApiOperation(value = "删除", notes = "删除")
    @RequestMapping(value = "/delete", method = {RequestMethod.POST})
    public Result delete(@RequestParam Long id) {
        Classroom classroom=new Classroom();
        classroom.setId(id);
        classroom.setIsDelete(true);
        classroomService.update(classroom);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "修改", notes = "修改")
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public Result update(@RequestBody Classroom classroom) {
        classroom.setUpdatedAt(new Date());
        classroomService.update(classroom);
        Result result=ResultGenerator.genSuccessResult();
        result.setData(classroom);
        return result;
    }

    @ApiOperation(value = "获取单个详情", notes = "获取单个详情")
    @RequestMapping(value = "/detail", method = {RequestMethod.POST})
    public Result detail(@RequestParam(value = "id", required = false) Long id) {
        if (null == id){
            return ResultGenerator.genSuccessResult(new Classroom());
        }else {
            Classroom classroom = classroomService.findById(id);
            if (null == classroom){
                return ResultGenerator.genSuccessResult(new Classroom());
            }else {
                return ResultGenerator.genSuccessResult(classroom);
            }
        }
    }

    @ApiOperation(value = "分页查询", notes = "分页查询")
    @RequestMapping(value = "/findByModal", method = {RequestMethod.POST})
    public Result list(@RequestBody(required =false) Classroom classroom) {

        if (null == classroom){
            classroom = new Classroom();
        }

        PageHelper.startPage(classroom.getPage() == null ? 0 : classroom.getPage(), classroom.getLimit() == null ? 10 : classroom.getLimit());
        classroom.setIsDelete(false);
        List<Classroom> list = classroomService.findByModel(classroom);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
