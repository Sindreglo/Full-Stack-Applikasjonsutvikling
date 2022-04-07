package ntnu.sindrgl.oving5.security;

import ntnu.sindrgl.oving5.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private UserRepo userRepo;
    private ArrayList<ntnu.sindrgl.oving5.model.User> users = new ArrayList<>();



    public CustomAuthenticationProvider() {
        super();
    }

    @Override
    public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
        final String name = authentication.getName();
        final String password = authentication.getCredentials().toString();
        users = (ArrayList<ntnu.sindrgl.oving5.model.User>) userRepo.findAll();
        Authentication auth = null;
        for (int i =0; i<users.size(); i++){
            if (name.equals(users.get(i).getUsername()) && password.equals(users.get(i).getPassword())) {
                final List<GrantedAuthority> grantedAuths = new ArrayList<>();
                grantedAuths.add(new SimpleGrantedAuthority("USER"));
                final UserDetails principal = new User(name, password, grantedAuths);
                auth = new UsernamePasswordAuthenticationToken(principal, password, grantedAuths);
                break;
            }
        }
        return auth;
    }

    @Override
    public boolean supports(final Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }


}

