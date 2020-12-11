package com.sid.Fort.ForgotPassword.Service;

import com.sid.Fort.ForgotPassword.DTO.ResetPassword;

public interface ForgotPasswordService {
    Object recoveremail(String Email);
     Object ResetPassword(ResetPassword resetPassword);
     boolean isValidtoken(String tocken);
}
