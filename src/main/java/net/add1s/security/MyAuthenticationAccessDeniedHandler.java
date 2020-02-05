package net.add1s.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.add1s.entity.common.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author mahoshojo
 */
@Component("myAuthenticationAccessDeniedHandler")
public class MyAuthenticationAccessDeniedHandler implements AccessDeniedHandler {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        // HttpServletResponse.SC_FORBIDDEN 403 禁止访问的资源
        httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
        httpServletResponse.setContentType("application/json;charset=UTF-8");
        PrintWriter writer = httpServletResponse.getWriter();
        writer.write(objectMapper.writeValueAsString(AjaxResult.me().setSuccess(false).setMsg("禁止访问")));
        writer.flush();
        writer.close();
    }
}
