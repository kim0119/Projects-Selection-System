package com.company.project.core;

/**
 * 响应码枚举，参考HTTP状态码的语义
 */
public enum ResultCode {
    SUCCESS(200),//成功
    FAIL(400),//失败
    UNAUTHORIZED(401),//未认证（签名错误）
    NOT_FOUND(404),//接口不存在
    INTERNAL_SERVER_ERROR(500),//服务器内部错误

    STUDENT_COURSE_ERROR(800027),//人数已经超过限制
    ADMIN_DELETE_ERROR(800026),//管理员权限不可删除
    ADMIN_ERROR(800025),//管理员权限不可修改
    USER_NULL_ERROR(800035),//该记录不存在或者已删除
    NOT_EXIST_TOKEN_EXCEPTION(800034),//不存在得token(请重新登录再访问)
    NOT_EXIST_USER_EXCEPTION(800033),//用户名或密码错误
    OUT_TIME_TOKEN(800032),//登录超时，请重新登录
    USER_ALREADY_EXIST(800031),//用户名已存在，请登录
    FILE_BULL_ERROR(800008),//文件不能为空
    FILEUPLOAD_ERROR(800007),//上传文件失败
    NOT_LOGIN_EXCEPTION(800005),//token不存在或token错误请重新登录
    PASSWORD_ERROR(800001),//密码输入错误，请重新输入
    USER_NOT_EXIST(800000)//用户信息不存在[账号可能被停用或删除]
    ;

    private final int code;

    ResultCode(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }
}
