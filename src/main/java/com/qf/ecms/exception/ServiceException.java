package com.qf.ecms.exception;


import com.qf.ecms.utils.ErrorStatus;
import com.qf.ecms.utils.ResponseEntity;

public class ServiceException extends Exception {
    private String msg;
    private int status;

    public ServiceException(String msg, int status) {
        this.msg = msg;
        this.status = status;
    }

    public ServiceException(ErrorStatus status) {
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

    /**
     * 返回错误信息
     * @return
     */
    public ResponseEntity getErrorResponseEntity (){
        return ResponseEntity.error(status,msg);
    }
}
