package com.waffle.data.dto.other;

import com.waffle.data.constants.types.user.UserStatus;
import com.waffle.data.dto.response.user.root.profile.ProfileAllResponseDto;
import com.waffle.data.entities.Authority;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import static com.waffle.data.constants.types.user.UserStatus.ACTIVE;
import static com.waffle.data.constants.types.user.UserStatus.INACTIVE;

/**
 * User security context information.
 */
@Data
public class UserContext implements UserDetails {
    private Long id;
    private UserStatus status;
    private ProfileAllResponseDto profile;

    private String password;
    private Set<Authority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities.stream()
                .map(a -> new SimpleGrantedAuthority(a.getName().toString()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.profile.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return !status.equals(ACTIVE);
    }

    @Override
    public boolean isAccountNonLocked() {
        return status.equals(INACTIVE);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return !status.equals(INACTIVE);
    }
}
