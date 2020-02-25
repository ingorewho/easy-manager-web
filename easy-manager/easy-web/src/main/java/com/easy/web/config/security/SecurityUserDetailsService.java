package com.easy.web.config.security;

import com.easy.service.system.user.UserService;
import com.easy.enums.UserStatusEnum;
import com.easy.response.ApiResponse;
import com.easy.response.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Author rzq
 * @Desc 登录用户接口
 * @Date 2020-02-20
 **/
@Service
public class SecurityUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApiResponse<UserVo> apiResponse = userService.findUserByUserName(username);
        if (apiResponse.isSuccess()) {
//            UserVo user = apiResponse.getData();
            UserVo user = new UserVo();
            return buildEasyUserDetails(user);
//            if (user != null) {
//                return buildEasyUserDetails(user);
//            }
        }
        return null;
    }

    /**
     * 构建UserDetails
     *
     * @param userVo
     * @return
     */
    private SecurityUserDetails buildEasyUserDetails(UserVo userVo) {
        return SecurityUserDetails.builder()
                .userName(userVo.getUserName())
                .passWord(userVo.getUserPwd())
                .enable(UserStatusEnum.NORMAL.getCode().equals(userVo.getStatus()))
                .build();
    }
}
