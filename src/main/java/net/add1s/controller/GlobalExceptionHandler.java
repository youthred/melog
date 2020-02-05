package net.add1s.controller;

import net.add1s.entity.common.AjaxResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 控制器全局异常处理
 *
 * @author pj.w@qq.com
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public AjaxResult globalExceptionHandler(Exception e) {
        e.printStackTrace();
        return AjaxResult.me().setSuccess(false).setMsg(e.getMessage());
    }
}
