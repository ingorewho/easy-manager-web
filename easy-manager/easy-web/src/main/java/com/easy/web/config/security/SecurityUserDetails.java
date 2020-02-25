package com.easy.web.config.security;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @Author rzq
 * @Desc security用户信息
 * @Date 2020-02-20
 **/
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SecurityUserDetails implements UserDetails {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户密码
     */
    private String passWord;
    /**
     * 用户是否可用
     */
    private Boolean enable;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return passWord;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return enable;
    }
}
