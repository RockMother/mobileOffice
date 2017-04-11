package mobileoffice.models.security;

import mobileoffice.dao.entities.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by kisc on 4/11/2017.
 */
public class UserDetailsImpl implements UserDetails {

    private final Users user;
    private final List<GrantedAuthority> authorities;

    public UserDetailsImpl(Users user, List<String> roles) {
        this.user = user;
        this.authorities = new ArrayList<>();
        for (final String role : roles) {
            this.authorities.add(new GrantedAuthorityImpl(role));
        }
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public String getPassword() {
        return user.getPassword();
    }

    public String getUsername() {
        return user.getUserName();
    }

    public boolean isAccountNonExpired() {
        return true;
    }

    public boolean isAccountNonLocked() {
        return true;
    }

    public boolean isCredentialsNonExpired() {
        return true;
    }

    public boolean isEnabled() {
        return user.getEnabled();
    }

    public long getId() {
        return user.getId();
    }
}
