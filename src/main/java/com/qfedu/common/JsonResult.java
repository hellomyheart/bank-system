package com.qfedu.common;

/**
 * @description
 * @className: JsonResult
 * @package: com.qfedu.common
 * @author: Stephen Shen
 * @date: 2020/9/3 下午2:15
 */
public class JsonResult {
    private int code;
    private Object info;

    public JsonResult(int code, Object info) {
        this.code = code;
        this.info = info;
    }

    public JsonResult() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }
}
