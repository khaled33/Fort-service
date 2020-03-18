package com.sid.Fort.UserDetails.Service;


import com.sid.Fort.UserDetails.Dao.AppUser;
import com.sid.Fort.UserDetails.Dao.Role;

public interface AccountService {
    public AppUser saveUser(AppUser users);
    public Role saveRole(Role role);
    public void addRoleToUser(String email, String rolename);
    public AppUser findUserByEmail(String username);

}
