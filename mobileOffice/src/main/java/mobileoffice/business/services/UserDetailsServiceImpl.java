package mobileoffice.business.services;

import mobileoffice.dao.contracts.AuthoritiesRepository;
import mobileoffice.dao.contracts.UsersRepository;
import mobileoffice.dao.entities.Authorities;
import mobileoffice.dao.entities.Users;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by kisc on 3/30/2017.
 */

//@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final String where_clause_user = "user_name=?";
    private final String where_clause_authorities = "user_id=?";

    private final UsersRepository usersRepository;
    private final AuthoritiesRepository authoritiesRepository;


    public UserDetailsServiceImpl(UsersRepository usersRepository, AuthoritiesRepository authoritiesRepository){
        this.usersRepository = usersRepository;
        this.authoritiesRepository = authoritiesRepository;
    }

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        List<Object> params = new ArrayList<Object>();
        params.add(s);
        List<Users> users = null;
        List<String > roles = null;
        try {
            users = usersRepository.findByParameters(where_clause_user, params);

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (users != null && users.size() > 0) {
            final Users user = users.get(0);
            try{
                params = new ArrayList<Object>();
                params.add(user.getId());
                List<Authorities> authorities = authoritiesRepository.findByParameters(where_clause_authorities, params);
                roles = new ArrayList<String>();
                for (Authorities authority: authorities){
                    roles.add(authority.getAuthority());
                }

            } catch (Exception e){
                e.printStackTrace();
            }
            return createUserDetails(user, roles);

        }
        throw new UsernameNotFoundException(s);
    }

    private UserDetails createUserDetails(Users user, List<String> roles) {
        return new UserDetailsImpl(user, roles);
    }

    class UserDetailsImpl implements UserDetails {

        private final Users user;
        private final List<GrantedAuthority> authorities;

        UserDetailsImpl(Users user, List<String> roles) {
            this.user = user;
            this.authorities = new ArrayList<GrantedAuthority>();
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
    }

    class GrantedAuthorityImpl implements GrantedAuthority {

        private String authority;

        GrantedAuthorityImpl(String authority){

            this.authority = authority;
        }

        public String getAuthority() {
            return authority;
        }
    }
}
