package com.qf.ecms.exception;


import com.qf.ecms.utils.ErrorStatus;
import lombok.Data;

/**
 * 20001 登录成功 xx
 * <p>
 * 400xx
 * 40002  账号密码或者错误
 * 40003  账号已被锁定 请于管理联系
 */
@Data
public class DaoException extends RuntimeException {
    private String msg;
    private int status;

    public DaoException(String msg, int status) {
        this.msg = msg;
        this.status = status;
    }
    public DaoException(ErrorStatus status) {
        this.msg = status.getMsg();
        this.status = status.getStatus();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
