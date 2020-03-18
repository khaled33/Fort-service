package com.sid.Fort.UserDetails.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUsersRepository extends JpaRepository<AppUser,Long> {
    public AppUser findByEmail(String email);
}
