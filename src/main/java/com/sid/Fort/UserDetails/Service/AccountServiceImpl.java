package com.sid.Fort.UserDetails.Service;

import com.sid.Fort.UserDetails.Entity.AppUser;
import com.sid.Fort.UserDetails.Dao.AppUsersRepository;
import com.sid.Fort.UserDetails.Entity.Role;
import com.sid.Fort.UserDetails.Dao.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

import static com.sid.Fort.config.URL_Image.URL_image.*;

@Service

public class AccountServiceImpl implements AccountService {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private AppUsersRepository appUsersRepository;
    @Autowired
    private RolesRepository rolesRepository;


    @Override
    public AppUser saveUser(AppUser users) {
         String hashPw=bCryptPasswordEncoder.encode(users.getPassword());
        users.setPassword(hashPw);
        users.setCreated(new Date());
        RestTemplate(users.getEmail());
        return appUsersRepository.save(users);
    }

    @Override
    public AppUser UpdateUser(AppUser users,Long idUser) {
        AppUser appUser=appUsersRepository.getOne(idUser);
        users.setId(idUser);
        users.setRoles(appUser.getRoles());
        users.setPassword(appUser.getPassword());
        users.setModified(new Date());

        return appUsersRepository.save(users);
    }

    @Override
    public AppUser UpdatePssword(AppUser users, Long idUser) {
        AppUser appUser=appUsersRepository.getOne(idUser);

        String hashPw=bCryptPasswordEncoder.encode(users.getPassword());
        appUser.setModified(new Date());

        appUser.setPassword(hashPw);
           return appUsersRepository.save(appUser);
    }

    @Override
    public Role saveRole(Role role) {
        return rolesRepository.save(role);
    }

    @Override
    public void addRoleToUser(String email, String rolename) {
        Role role= rolesRepository.findByRoleName(rolename);
        AppUser appUser=appUsersRepository.findByEmail(email);
        appUser.getRoles().add(role);
    }

    @Override
    public AppUser findUserByEmail(String email) {
        return appUsersRepository.findByEmail(email);
    }

    @Override
    public List<AppUser> getAllUser() {
        return appUsersRepository.findAll();
    }


    private boolean RestTemplate(String Email) {
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

        map.put("to", to);
        map.put("bodyUrl", Url_PAGE_Login_PASSWORD_PROD);
        map.put("bodyMessage", "Your registration request is being processed  .\n" );

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

}
