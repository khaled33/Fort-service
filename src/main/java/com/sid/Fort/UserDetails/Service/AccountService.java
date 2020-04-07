package com.sid.Fort.UserDetails.Service;


import com.sid.Fort.UserDetails.Entity.AppUser;
import com.sid.Fort.UserDetails.Entity.Role;

public interface AccountService {
    public AppUser saveUser(AppUser users);
    public Role saveRole(Role role);
    public void addRoleToUser(String email, String rolename);
    public AppUser findUserByEmail(String username);

}
