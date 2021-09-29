package com.hexaview.loginMs.service;

import com.hexaview.loginMs.dao.model.Login;
import com.hexaview.loginMs.dao.repo.LoginRepo;
import com.hexaview.loginMs.request.LoginVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RegisterService {
    @Autowired
    LoginRepo loginRepo;

    public boolean register(LoginVO loginVO){
        log.info("Checking if any registered user present with username " + loginVO.getUsername());
        Login user = loginRepo.findByUsername(loginVO.getUsername()).orElse(null);
        if(user != null){
            log.warn("User already registered.");
            return false;
        }
        int index  = (int) (loginRepo.count() + 1);
        Login newUser = new Login();
        newUser.setId(index);
        newUser.setUsername(loginVO.getUsername());
        newUser.setPassword(loginVO.getPassword());
        loginRepo.save(newUser);
        log.info("Successfully registered.");
        return true;
    }
}
