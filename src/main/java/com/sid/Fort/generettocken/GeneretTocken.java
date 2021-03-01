package com.sid.Fort.generettocken;

import com.sid.Fort.ForgotPassword.DTO.ResetPassword;
import com.sid.Fort.helpers.JWebToken;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

@RestController
public class GeneretTocken {
    private final int EXPIRATION_TIME_Token = 900000*100;

    @GetMapping("/GeneretTocken")
    public Object generetTocken() {
        JSONObject jwtPayload = new JSONObject();
        jwtPayload.put("status", 0);

        JSONArray audArray = new JSONArray();
        audArray.put("admin");
        jwtPayload.put("sub", "formToken");

        jwtPayload.put("aud", audArray);
        jwtPayload.put("exp", new Date(System.currentTimeMillis() + EXPIRATION_TIME_Token).getTime()); //this needs to be configured
        ResetPassword token=new ResetPassword();
        token.setTocken( new JWebToken(jwtPayload).toString());
        return token;
    }

    public boolean isValidtoken(String token) {
        JWebToken incomingToken;

        try {
            incomingToken = new JWebToken(token);
            System.out.println(incomingToken.isValid());
            if (incomingToken.isValid()) {
                return true;

            } else return false;
        } catch (NoSuchAlgorithmException ex) {
            return false;
        }

    }
}
