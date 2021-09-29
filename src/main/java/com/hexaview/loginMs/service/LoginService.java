package com.hexaview.loginMs.service;

import com.hexaview.loginMs.dao.model.Login;
import com.hexaview.loginMs.dao.repo.LoginRepo;
import com.hexaview.loginMs.request.LoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.security.SecureRandom;
import java.util.Base64;


@Slf4j
@Component
public class LoginService {
    @Autowired
    LoginRepo loginRepo;

    private static final SecureRandom secureRandom = new SecureRandom(); //threadsafe
    private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder(); //threadsafe

    public static String generateNewToken() {
        byte[] randomBytes = new byte[128];
        secureRandom.nextBytes(randomBytes);
        return base64Encoder.encodeToString(randomBytes);
    }
    public  String validate(LoginVO loginVO){
        log.info("Trying to login using username :" + loginVO.getUsername() + " password :" + loginVO.getPassword());
        Login user = loginRepo.findByUsername(loginVO.getUsername()).orElse(null);
        if(user == null){
            return "userNotFoundException";
        }
        if(user.getPassword().equals(loginVO.getPassword())){
            log.info("Login Successful");
            String token = generateNewToken();
            log.info("\tYour security token :" + token);
            return token;
        }else {
            return "PasswordMismatchException";
        }

    }



    /*
        call the repo class. fetch the login object based on username. match the password.
        open login dao and login VO

        If the password is matched generate a security token using java.secure.secureRandom;
        return this token


        If password is not matched throw the exception. PasswordNotMatchedException
     */
}
