package mobileoffice.models.security;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by kisc on 4/11/2017.
 */
public class GrantedAuthorityImpl implements GrantedAuthority {

    private String authority;

    public GrantedAuthorityImpl(String authority){
        this.authority = authority;
    }

    public String getAuthority() {
        return authority;
    }
}
