package com.easy.web.config.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Author rzq
 * @Desc 认证成功回调
 * @Date 2020-02-20
 **/
@Component
@Slf4j
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("auth success!");
        String sessionId = request.getRequestedSessionId();
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.write("{\"code\":\"SUCCESS\",\"message\":\"登录成功！\",\"date\":\"" + System.currentTimeMillis() + "\"}");
        out.flush();
        out.close();
        //登录成功保存用户关联信息到session
    }
}
