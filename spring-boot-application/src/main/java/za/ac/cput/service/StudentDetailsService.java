package za.ac.cput.service;


import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class StudentDetailsService implements UserDetailsService{

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if ("student".equals(username)) {
            return User.builder()
                    .username("student")
                    .password("$2a$12$zN1Pqz7D9u3LzKPURFOPUuU1lmhZ2H3FKmZpxhfQkQlqz1Re9ZZC6")
                    .roles("USER")
                    .build();
        }

        throw new UsernameNotFoundException("User not found: " + username);
    }
}
