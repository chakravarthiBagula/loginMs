package com.hexaview.loginMs.service;

import com.hexaview.loginMs.dao.model.Login;
import com.hexaview.loginMs.dao.repo.LoginRepo;
import com.hexaview.loginMs.request.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterService {
    @Autowired
    LoginRepo loginRepo;

    public boolean register(LoginVO loginVO){
        System.out.println("Checking if any registered user present with username " + loginVO.getUsername());
        Login user = loginRepo.findByUsername(loginVO.getUsername()).orElse(null);
        if(user != null){
            System.out.println("User already registered.");
            return false;
        }
        int index  = (int) (loginRepo.count() + 1);
        Login newUser = new Login();
        newUser.setId(index);
        newUser.setUsername(loginVO.getUsername());
        newUser.setPassword(loginVO.getPassword());
        loginRepo.save(newUser);
        System.out.println("Successfully registered.");
        return true;
    }
}
