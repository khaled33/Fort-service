package com.sid.Fort.ForgotPassword.Controller;

import com.sid.Fort.ForgotPassword.DTO.ResetPassword;
import com.sid.Fort.ForgotPassword.Service.ForgotPasswordService;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ForgotPasswordController {
    @Autowired
    private ForgotPasswordService forgotPasswordService;

    @PostMapping(path = "/ForgotPasswor/{Email}")
    public ResponseEntity<Object> recoveremail(@PathVariable String Email) {
        return new ResponseEntity<>(forgotPasswordService.recoveremail(Email),HttpStatus.CREATED);
    }
    @PostMapping("/ResetPassord")
    public ResponseEntity<Object> ResetPassword(@RequestBody ResetPassword resetpassword) {
         return new ResponseEntity<>(forgotPasswordService.ResetPassword(resetpassword),HttpStatus.CREATED);
    }
    @PostMapping("/ValidToken")
    public boolean isValidtoken(@RequestBody  String tocken) {
        return forgotPasswordService.isValidtoken(tocken);
    }
}
