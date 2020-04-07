package com.sid.Fort.UserDetails.Controller;

import com.sid.Fort.UserDetails.Entity.AppUser;
import com.sid.Fort.UserDetails.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountUserController {
    @Autowired
    private AccountService accountService;

    @PostMapping("/Register")
    public ResponseEntity<AppUser> Register(@RequestBody AppUser appUser) {


                 return new ResponseEntity<>(accountService.saveUser(appUser), HttpStatus.CREATED);

    }

    @GetMapping("/getUserByEmail/{email}")
    public ResponseEntity<AppUser> Login(@PathVariable String email) {


        return new ResponseEntity<>(accountService.findUserByEmail(email), HttpStatus.CREATED);

    }
//
//    @PostMapping("/Register")
//    public ResponseEntity<Void> addRoleToUser(@RequestBody AppUser appUser) {
//
//        return new ResponseEntity<>(accountService.addRoleToUser(appUser), HttpStatus.CREATED);
//
//    }

}
