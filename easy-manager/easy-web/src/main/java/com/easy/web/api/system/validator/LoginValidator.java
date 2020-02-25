package com.easy.web.api.system.validator;

import com.easy.response.ApiResponse;
import com.easy.response.vo.UserVo;
import com.easy.util.StringUtil;
import com.easy.web.api.system.request.UserNameLoginReq;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @Author rzq
 * @Desc 登录校验
 * @Date 2020-02-21
 **/
@Component
@Slf4j
public class LoginValidator {
    /**
     * 用户名最长长度.
     **/
    private static final Integer USERNAME_MAX_LEN = 10;
    /**
     * 密码最长长度.
     **/
    private static final Integer PASSWORD_MAX_LEN = 10;

    /**
     * 校验用户名密码登录参数
     *
     * @param userNameLoginReq
     * @return
     */
    public ApiResponse validateUserNamePwdLoginParam(UserNameLoginReq userNameLoginReq) {
        if (Objects.isNull(userNameLoginReq)) {
            log.error("LoginValidator validateUserNamePwdLogin userNameLoginReq isNull!");
            return ApiResponse.buildValidateExResponse("请求为空");
        }

        if (StringUtils.isEmpty(userNameLoginReq.getUserName())) {
            log.error("LoginValidator validateUserNamePwdLogin userName isEmpty!");
            return ApiResponse.buildValidateExResponse("用户名为空");
        }

        if (StringUtil.overLength(userNameLoginReq.getUserName(), USERNAME_MAX_LEN)) {
            log.error("LoginValidator validateUserNamePwdLogin userName overLength! maxLength:{}", USERNAME_MAX_LEN);
            return ApiResponse.buildValidateExResponse("用户名超长");
        }

        if (StringUtils.isEmpty(userNameLoginReq.getPassWord())) {
            log.error("LoginValidator validateUserNamePwdLogin passWord isEmpty!");
            return ApiResponse.buildValidateExResponse("密码为空");
        }

        if (StringUtil.overLength(userNameLoginReq.getPassWord(), PASSWORD_MAX_LEN)) {
            log.error("LoginValidator validateUserNamePwdLogin passWord overLength! maxLength:{}", PASSWORD_MAX_LEN);
            return ApiResponse.buildValidateExResponse("密码超长");
        }
        return ApiResponse.buildSuccessResponse(null);
    }

    /**
     * 校验密码正确性
     *
     * @param inputPwd
     * @param userVo
     * @return
     */
    public ApiResponse validatePwd(String inputPwd, UserVo userVo) {
        if (Objects.isNull(userVo)) {
            log.error("LoginValidator validatePwd userVo isNull!");
            return ApiResponse.buildValidateExResponse("用户不存在");
        }

        boolean correct = inputPwd.equals(userVo.getUserPwd());
        if (!correct) {
            log.error("LoginValidator validatePwd inputPwd is not correct!");
            return ApiResponse.buildValidateExResponse("用户输入密码错误");
        }
        return ApiResponse.buildSuccessResponse(null);
    }
}
