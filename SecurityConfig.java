package za.ac.cput.config;


import org.springframework.security.authentication.AuthenticationProvider;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import za.ac.cput.service.StudentDetailsService;




@Configuration
@EnableMethodSecurity(prePostEnabled = true) // This enables @PreAuthorize
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }


//            //please configure security filter chain here
//            public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//                http
//                        .cors(cors -> cors.configure(http))
//                        .csrf(csrf -> csrf.disable())
//                        .sessionManagement(session ->
//                                session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                        )
//                        .authorizeHttpRequests(auth -> auth
//                                .requestMatchers("/api/auth/**").permitAll()
//                                .anyRequest().authenticated()
//                        );
//                http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//                return http.build();
//            }



    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }







}
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.cors(cors->cors.configure(http))
//                .csrf(csrf->csrf.disable())
//                .sessionManagement(session->
//                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//
//                .authorizeHttpRequests(auth->auth
//                        .requestMatchers("/customer/login").permitAll()
//                        .requestMatchers("/customer/create").permitAll()
//                        .requestMatchers("/products/getAll").permitAll()
//                        .requestMatchers("/products/**").permitAll()
//
//                        .requestMatchers("/admin/**").hasRole("ADMIN")
//
//                        .requestMatchers("/customer/me").authenticated()
//                        .requestMatchers("/customer/update").authenticated()
//                        .requestMatchers("/customer/delete").authenticated()
//                        .requestMatchers("/customer/getAll").permitAll()
//
//                        .requestMatchers("/order**").authenticated()
//                        .requestMatchers("/wishlist**").authenticated()
//                        .requestMatchers("/address**").authenticated()
//                        .requestMatchers("/cart**").authenticated()
//                        .requestMatchers("/cart-items/**").authenticated();
//
//
//
//
//
//
//
//
//
//
//
//
//    }
//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
//        provider.setUserDetailsService(userDetailsService);
//        return provider;
//    }
//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails user1=User.withDefaultPasswordEncoder()
//                .username("user1")
//                .password("password")
//                .roles("USER")
//                .build();
//
//        UserDetails user2=User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("password123")
//                .roles("USER").build();
//        return new InMemoryUserDetailsManager(user1,user2);


