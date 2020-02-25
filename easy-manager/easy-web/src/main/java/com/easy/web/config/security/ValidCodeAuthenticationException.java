package com.easy.web.config.security;

import org.springframework.security.core.AuthenticationException;

/**
 * @Author rzq
 * @Desc
 * @Date 2020-02-20
 **/
public class ValidCodeAuthenticationException extends AuthenticationException {
    public ValidCodeAuthenticationException(String msg) {
        super(msg);
    }
}
