package com.waffle.data.dto.other;

import com.waffle.data.constants.types.user.UserStatus;
import com.waffle.data.dto.common.base.UserDto;
import com.waffle.data.dto.response.user.root.UserAllResponseDto;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * User security context information.
 */
@Data
public class UserInfo extends UserAllResponseDto implements UserDetails {

    private String password;

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return super.getProfile().getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return super.getStatus() == UserStatus.ACTIVE;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return super.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().toString()))
                .collect(Collectors.toList());
    }
}
