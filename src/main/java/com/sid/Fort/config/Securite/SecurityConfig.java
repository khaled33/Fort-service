package com.sid.Fort.config.Securite;

import com.sid.Fort.UserDetails.Service.ImpUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private static final String[] AUTH_WHITELIST = {
            // -- swagger ui
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**"
            // other public endpoints of your API may be appended to this array
    };
    @Autowired
    private ImpUserDetailsService userDetailsService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
        .passwordEncoder(bCryptPasswordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
       // http.formLogin();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers("/login/**","/Register/**").permitAll();
        http.authorizeRequests().antMatchers(AUTH_WHITELIST).permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/tasks/**").hasAuthority("ADMIN");
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(new JWTAauthentficationFilter(authenticationManager()));
        http.addFilterBefore(new JWTAuthorrizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
