package com.company.project.web;

import com.company.project.common.BaseController;
import com.company.project.core.Result;
import com.company.project.core.ResultCode;
import com.company.project.core.ResultGenerator;
import com.company.project.model.User;
import com.company.project.service.UserService;
import com.company.project.utils.Logger;
import com.company.project.vo.LoginVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//用于处理关于用户管理的HTTP请求
//基于Spring框架的MVC模式实现，使用了Swagger注解实现API文档自动生成
@RestController
@RequestMapping("/user")
@Api(tags = {"/user"}, description = "用户管理模块")
public class UserController extends BaseController {
    @Resource
    private UserService userService;

    //接收一个userId参数，记录日志并调用userService中的logout方法进行业务逻辑处理，返回处理结果
    @ApiOperation(value = "用户退出", notes = "用户退出")
    @RequestMapping(value = "/logout", method = {RequestMethod.POST})
    public Result logout(@RequestParam Long userId) {
        Logger.info(this,"/user/logout 用户退出接口入参 : " + userId);
        return userService.logout(userId);
    }

    //接收一个LoginVo类型的参数vo和HttpServletRequest类型的参数request，记录日志调用userService中的login方法
    @ApiOperation(value = "用户登录", notes = "用户登录")
    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    public Result login(@RequestBody LoginVo vo, HttpServletRequest request) {
        Logger.info(this, "/user/login 用户登录接口入参 :" + vo);
        return userService.login(vo);
    }

    @ApiOperation(value = "批量发送邮件", notes = "批量发送邮件")
    @RequestMapping(value = "/batchSendEmail", method = {RequestMethod.POST})
    public Result batchSendEmail(@RequestBody String ids) {
        return userService.batchSendEmail(ids);
    }

    @ApiOperation(value = "生成验证码", notes = "生成验证码")
    @RequestMapping(value = "/captcha", method = {RequestMethod.POST})
    public Result captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return userService.captcha();
    }

    //接收一个User类型的参数user，调用userService中的add方法
    @ApiOperation(value = "用户注册", notes = "用户注册")
    @RequestMapping(value = "/add", method = {RequestMethod.POST})
    public Result add(@RequestBody User user) {
        return userService.add(user);
    }

    //调用父类BaseController中的getUserId获取userId，如果userId为空则返回”token不存在或token错误“否则调用detailByToken方法
    @ApiOperation(value = "根据token获取用户详情", notes = "根据token获取用户详情")
    @RequestMapping(value = "/detailByToken", method = {RequestMethod.POST})
    public Result detailByToken() {
        if (super.getUserId() == null){
            return ResultGenerator.genFailResult(ResultCode.NOT_LOGIN_EXCEPTION,"token不存在或token错误请重新登录");
        }else {
            return userService.detailByToken(Long.valueOf(super.getUserId()));
        }
    }

    //接受一个Long类型的参数id，调用userService中的delete
    @ApiOperation(value = "删除用户", notes = "删除用户")
    @RequestMapping(value = "/delete", method = {RequestMethod.POST})
    public Result delete(@RequestParam(value = "id", required = false) Long id) {
        return userService.delete(id);
    }

    //接受一个User类型的参数user
    @ApiOperation(value = "修改用户", notes = "修改用户")
    @RequestMapping(value = "/update", method = {RequestMethod.POST})
    public Result updateUser(@RequestBody User user) {
        return  userService.updateUser(user);
    }

    //接受一个Long类型的参数id，id为空则返回空的User对象，否则根据id查询用户详情并返回处理结果
    @ApiOperation(value = "获取用户单个详情", notes = "获取用户单个详情")
    @RequestMapping(value = "/detail", method = {RequestMethod.POST})
    public Result detail(@RequestParam(value = "id", required = false) Long id) {
        //根据id查询详情
        if (null == id){
            return ResultGenerator.genSuccessResult(new User());
        }else {
            User user = userService.findById(id);
            if (null == user){
                return ResultGenerator.genSuccessResult(new User());
            }else {
                user.setRole(user.getRoleId());
                //返回查询的单个详情
                return ResultGenerator.genSuccessResult(user);
            }
        }
    }

    @ApiOperation(value = "分页查询用户", notes = "分页查询用户")
    @RequestMapping(value = "/findByModal", method = {RequestMethod.POST})
    public Result list(@RequestBody(required =false) User user) {
        return userService.list(user);
    }

    @ApiOperation(value = "分页查询所有表和字段", notes = "分页查询所有表和字段")
    @RequestMapping(value = "/findAllColumns", method = {RequestMethod.POST})
    public Result findAllColumns() {
        return userService.findAllColumns();
    }

}
