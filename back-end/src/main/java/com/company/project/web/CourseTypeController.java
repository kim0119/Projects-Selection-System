package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.CourseType;
import com.company.project.service.CourseTypeService;
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
@RequestMapping("/course/type")
@Api(tags = {"/course/type"}, description = "课程类别管理模块")
public class CourseTypeController extends BaseController{
    @Resource
    private CourseTypeService courseTypeService;

    @ApiOperation(value = "新增", notes = "新增")
    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    public Result add(@RequestBody CourseType courseType) {
        courseType.setCreatedAt(new Date());
        courseType.setIsDelete(false);
        courseType.setCreatedBy(super.getUserId());
        courseTypeService.save(courseType);
        Result result=ResultGenerator.genSuccessResult();
        result.setData(courseType);
        return result;
    }

    @ApiOperation(value = "删除", notes = "删除")
    @RequestMapping(value = "/delete", method = {RequestMethod.POST})
    public Result delete(@RequestParam Long id) {
        CourseType courseType=new CourseType();
        courseType.setId(id);
        courseType.setIsDelete(true);
        courseTypeService.update(courseType);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "修改", notes = "修改")
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public Result update(@RequestBody CourseType courseType) {
        courseType.setUpdatedAt(new Date());
        courseTypeService.update(courseType);
        Result result=ResultGenerator.genSuccessResult();
        result.setData(courseType);
        return result;
    }

    @ApiOperation(value = "获取单个详情", notes = "获取单个详情")
    @RequestMapping(value = "/detail", method = {RequestMethod.POST})
    public Result detail(@RequestParam(value = "id", required = false) Long id) {
        if (null == id){
            return ResultGenerator.genSuccessResult(new CourseType());
        }else {
            CourseType courseType = courseTypeService.findById(id);
            if (null == courseType){
                return ResultGenerator.genSuccessResult(new CourseType());
            }else {
                return ResultGenerator.genSuccessResult(courseType);
            }
        }
    }

    @ApiOperation(value = "分页查询", notes = "分页查询")
    @RequestMapping(value = "/findByModal", method = {RequestMethod.POST})
    public Result list(@RequestBody(required =false) CourseType courseType) {

        if (null == courseType){
            courseType = new CourseType();
        }

        PageHelper.startPage(courseType.getPage() == null ? 0 : courseType.getPage(), courseType.getLimit() == null ? 10 : courseType.getLimit());
        courseType.setIsDelete(false);
        List<CourseType> list = courseTypeService.findByModel(courseType);
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
