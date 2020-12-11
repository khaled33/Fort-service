package com.sid.Fort.ForgotPassword.Service;

import com.sid.Fort.ForgotPassword.DTO.ResetPassword;
import com.sid.Fort.UserDetails.Dao.AppUsersRepository;
import com.sid.Fort.UserDetails.Entity.AppUser;
import com.sid.Fort.helpers.JWebToken;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.security.NoSuchAlgorithmException;
import java.util.*;

import static com.sid.Fort.config.URL_Image.URL_image.*;

@Component
public class ForgotPasswordServiceImpl implements ForgotPasswordService {
    @Autowired
    private AppUsersRepository appUsersRepository;

    private static final int EXPIRATION_TIME = 900000;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public Object recoveremail(String Email) {

        response response = new response();


        Optional<AppUser> appUser = Optional.ofNullable(appUsersRepository.findByEmail(Email.trim()));
        if (appUser.isPresent()) {
            if (RestTemplate(Email, generetTocken(Email))) {
                response.setMessage("An Email Has Been Sent");
                response.setType("Sent Mail");
                return response;
            } else {
                response.setMessage("Error Sent Mail");
                response.setType("Sent Mail");
                return response;
            }
        } else {
            response.setMessage("This Email Does Not Exist");
            response.setType("get User");
            return response;
        }


    }

    @Override
    public Object ResetPassword(ResetPassword resetpassword) {
        response response = new response();
        //verify and use
        JWebToken incomingToken;
        System.out.println(resetpassword.toString());
        try {
            String token = new JWebToken(resetpassword.getTocken()).toString();

            incomingToken = new JWebToken(token);
            if (incomingToken.isValid()) {
                response.setType("tocken");
                response.setMessage("valid Token");

                String[] parts = token.split("\\.");

                JSONObject payload = new JSONObject(JWebToken.decode(parts[1]));
                String Email = payload.getString("sub");
                AppUser appUser = appUsersRepository.findByEmail(Email);
//
                String hashPw = bCryptPasswordEncoder.encode(resetpassword.getPassword());
                appUser.setModified(new Date());
//
                appUser.setPassword(hashPw);
                appUsersRepository.save(appUser);

                return response;
            } else {
                response.setType("tocken");
                response.setMessage("Invalid Token");
                return response;
            }
        } catch (NoSuchAlgorithmException ex) {
            response.setType("tocken");
            response.setMessage("Invalid Token" + ex.getMessage());
            return response;

        }
    }

    @Override
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

    private String generetTocken(String email) {
        JSONObject jwtPayload = new JSONObject();
        jwtPayload.put("status", 0);

        JSONArray audArray = new JSONArray();
        audArray.put("admin");
        jwtPayload.put("sub", email);

        jwtPayload.put("aud", audArray);
        jwtPayload.put("exp", new Date(System.currentTimeMillis() + EXPIRATION_TIME).getTime()); //this needs to be configured

        return new JWebToken(jwtPayload).toString();
    }

    private boolean RestTemplate(String Email, String Token) {
        // request url
        List<String> to = new ArrayList<>();
        to.add(Email);
// create an instance of RestTemplate
        RestTemplate restTemplate = new RestTemplate();

// create headers
        HttpHeaders headers = new HttpHeaders();
// set `content-type` header
        headers.setContentType(MediaType.APPLICATION_JSON);
// set `accept` header
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));

// request body parameters
        Map<String, Object> map = new HashMap<>();
        StringBuilder Url = new StringBuilder();
        Url.append(Url_PAGE_Reset_PASSWORD_PROD);
        Url.append(Token);
        map.put("to", to);
        map.put("bodyUrl", Url);
        map.put("bodyMessage", "Someone, hopefully you, has requested to reset the password for your Fort account  .\n" +
                "\n" +
                "If you did not perform this request, you can safely ignore this email.\n" +
                "\n" +
                "Otherwise, click the link below to complete the process.");

// build the request
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(map, headers);

        System.out.println(entity.toString());
// send POST request
        ResponseEntity<String> response = restTemplate.postForEntity(REST_TEMPLATE, entity, String.class);

// check response
        if (response.getStatusCode() == HttpStatus.OK) {
            System.out.println("Request Successful");
            System.out.println(response.getBody());
            return true;
        } else {
            System.out.println("Request Failed");
            System.out.println(response.getStatusCode());
            return false;
        }
    }

    class response {

        private String message;
        private String type;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }


}
