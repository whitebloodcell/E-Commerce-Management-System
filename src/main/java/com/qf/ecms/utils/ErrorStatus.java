package com.qf.ecms.utils;

public enum ErrorStatus {
    SUCCESS(20000, "success", "成功"),
    POST_SUCCESS(20001, "success", "提交数据成功"),
    SERVICE_ERROR(40001, "service  error", "数据异常, 请重新在试"),
    DAO_ERROR(40001, "service  error", "数据层异常"),
    SYS_ERROR(40004, "sys  error", "系统繁忙, 请重新在试"),
    DATA_ERROR(40005,"data error","数据异常"),
    REGISTER_NAME_ERROR(40003, "register  error","用户名存在"),
    REGISTER_PHONE_ERROR(40003, "register  error","手机号存在"),
    REGISTER_EMAIL_ERROR(40003, "register  error","邮箱存在"),
    DELETE_ERROR(40006,"delete error","删除失败");
    int status;
    String msg;
    String tip;

    ErrorStatus(int status, String msg, String tip) {
        this.status = status;
        this.msg = msg;
        this.tip = tip;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }
}
