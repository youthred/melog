package net.add1s.entity.common;

/**
 * Ajax请求响应对象
 *
 * @author mahoshojo
 */
public class AjaxResult {

    private boolean success = true;

    private String msg = "Successful operation!";

    private Object resultObj;

    public boolean isSuccess() {
        return success;
    }

    public AjaxResult setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public AjaxResult setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getResultObj() {
        return resultObj;
    }

    public AjaxResult setResultObj(Object resultObj) {
        this.resultObj = resultObj;
        return this;
    }

    public static AjaxResult me() {
        return new AjaxResult();
    }
}