package com.fm.famliymoney.until;

public enum ResultEnum {
    SUCCESS(true, "请求成功"),
    ERROR(false, "请求失败"),
    SYSTEM_ERROR(false, "系统异常"),
    BUSSINESS_ERROR(false, "业务逻辑错误"),
    VERIFY_CODE_ERROR(false, "业务参数错误"),
    PARAM_ERROR(false, "业务参数错误");

    private Boolean code;
    private String msg;

    void ResultEnums(Boolean code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    ResultEnum(Boolean code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public Boolean getCode() {
        return code;
    }

    public void setCode(Boolean code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
