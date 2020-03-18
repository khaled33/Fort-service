package com.sid.Fort.UserDetails.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Role,Long> {
    public Role findByRoleName(String roleName);
}
