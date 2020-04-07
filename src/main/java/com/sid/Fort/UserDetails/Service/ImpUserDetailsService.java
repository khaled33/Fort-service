package com.sid.Fort.UserDetails.Service;

import com.sid.Fort.UserDetails.Entity.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class ImpUserDetailsService implements UserDetailsService {
    @Autowired
    private AccountService accountService;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        AppUser appUser= accountService.findUserByEmail(email);
        if (appUser==null)throw new UsernameNotFoundException(email);
        Collection<GrantedAuthority> authorities =new ArrayList<>();

        appUser.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        });
    return new User(appUser.getEmail(),appUser.getPassword(),authorities);
    }
}
