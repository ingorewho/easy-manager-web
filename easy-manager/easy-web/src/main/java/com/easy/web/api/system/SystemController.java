package com.easy.web.api.system;

import com.alibaba.fastjson.JSONObject;
import com.easy.service.system.user.UserService;
import com.easy.response.ApiResponse;
import com.easy.response.vo.UserVo;
import com.easy.web.api.system.validator.LoginValidator;
import com.easy.web.config.security.ValidateHandleService;
import com.easy.web.api.system.request.UserNameLoginReq;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.util.Map;

/**
 * @Author rzq
 * @Desc 登录web-service
 * @Date 2020-02-20
 **/
@RestController
@RequestMapping(value = "/system")
@Slf4j
public class SystemController {
    @Autowired
    private UserService userService;
    @Autowired
    private ValidateHandleService handleService;
    @Autowired
    private LoginValidator loginValidator;

    @ApiOperation(value = "获取验证码图片")
    @GetMapping("/getVerificationCode")
    public void getVerificationCode(@ApiParam(hidden = true) @RequestParam Map<String, Object> params
            , @ApiParam(hidden = true) HttpServletRequest request
            , @ApiParam(hidden = true) HttpServletResponse response) {
        ServletOutputStream out = null;
        try {
            response.setDateHeader("Expires", 0);
            response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
            response.addHeader("Cache-Control", "post-check=0, pre-check=0");
            response.setHeader("Pragma", "no-cache");
            response.setContentType("image/jpeg");

            BufferedImage validateCode = handleService.createValidateCode();
            out = response.getOutputStream();
            ImageIO.write(validateCode, "jpg", out);
            out.flush();
        } catch (Exception ex) {
            log.error("获取验证码图片发生异常.", ex);
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (Exception ex) {
                    log.error("关闭输出流发生异常.", ex);
                }
            }
        }
    }

    @ApiOperation(value = "登录接口：根据用户名和密码登录")
    @PostMapping(value = "/login/username/password")
    public ApiResponse<UserVo> loginByNameAndPwd(UserNameLoginReq loginReq) {
        try {
            ApiResponse validateResp = loginValidator.validateUserNamePwdLoginParam(loginReq);
            if (!validateResp.isSuccess()) {
                return validateResp;
            }

            ApiResponse<UserVo> userResp = userService.findUserByUserName(loginReq.getUserName());
            if (!userResp.isSuccess()) {
                return userResp;
            }

            validateResp = loginValidator.validatePwd(loginReq.getUserName(), userResp.getData());
            if (!validateResp.isSuccess()) {
                return validateResp;
            }
            return userResp;
        } catch (Exception ex) {
            log.error("登录异常, 登录请求:{}", JSONObject.toJSONString(loginReq));
            return ApiResponse.buildBusExResponse("登录异常");
        }
    }

    @GetMapping(value = "/login")
    public String login() {
        return "login";
    }

    @GetMapping("/")
    public String root() {
        return "index";
    }

}
