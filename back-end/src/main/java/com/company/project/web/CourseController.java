package com.company.project.web;
import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.Course;
import com.company.project.service.CourseService;
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
@RequestMapping("/course")
@Api(tags = {"/course"}, description = "课程管理模块")
public class CourseController extends BaseController{
    @Resource
    private CourseService courseService;

    @ApiOperation(value = "新增", notes = "新增")
    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    public Result add(@RequestBody Course course) {
        course.setCreatedAt(new Date());
        course.setIsDelete(false);
        course.setCreatedBy(super.getUserId());
        courseService.save(course);
        Result result=ResultGenerator.genSuccessResult();
        result.setData(course);
        return result;
    }

    @ApiOperation(value = "删除", notes = "删除")
    @RequestMapping(value = "/delete", method = {RequestMethod.POST})
    public Result delete(@RequestParam Long id) {
        Course course=new Course();
        course.setId(id);
        course.setIsDelete(true);
        courseService.update(course);
        return ResultGenerator.genSuccessResult();
    }

    @ApiOperation(value = "修改", notes = "修改")
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public Result update(@RequestBody Course course) {
        course.setUpdatedAt(new Date());
        courseService.update(course);
        Result result=ResultGenerator.genSuccessResult();
        result.setData(course);
        return result;
    }

    @ApiOperation(value = "获取单个详情", notes = "获取单个详情")
    @RequestMapping(value = "/detail", method = {RequestMethod.POST})
    public Result detail(@RequestParam(value = "id", required = false) Long id) {
        if (null == id){
            return ResultGenerator.genSuccessResult(new Course());
        }else {
            Course course = courseService.findById(id);
            if (null == course){
                return ResultGenerator.genSuccessResult(new Course());
            }else {
                return ResultGenerator.genSuccessResult(course);
            }
        }
    }

    @ApiOperation(value = "分页查询", notes = "分页查询")
    @RequestMapping(value = "/findByModal", method = {RequestMethod.POST})
    public Result list(@RequestBody(required =false) Course course) {
        return courseService.list(course);
    }
}
