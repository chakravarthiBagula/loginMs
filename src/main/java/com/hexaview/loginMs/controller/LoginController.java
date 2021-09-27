package com.hexaview.loginMs.controller;


import com.hexaview.loginMs.request.LoginVO;
import com.hexaview.loginMs.service.LoginService;
import com.hexaview.loginMs.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class LoginController {
    @Autowired
    LoginService loginService;

    @Autowired
    RegisterService registerService;

    @GetMapping("/")
    public String index(Model model) {
        return "home.jsp";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(LoginVO loginVO, Model model) {
        String token = loginService.match(loginVO);

        if (token.equalsIgnoreCase("userNotFoundException")) {
            model.addAttribute("error", "INVALID USERNAME");
        } else if (token.equalsIgnoreCase("PasswordMismatchException")) {
            model.addAttribute("error", "INVALID PASSWORD");
        } else {
            model.addAttribute("username", loginVO.getUsername());
            model.addAttribute("token", token);
            return "disp.jsp";
        }
        return "home.jsp";
    }

    @RequestMapping(value = "/register")
    public String registerPage() {
        return "register.jsp";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(LoginVO loginVO, Model model) {
        boolean success = registerService.register(loginVO);
        if (success) {
            model.addAttribute("msg", "Successfully Registered");
        } else {
            model.addAttribute("error", "User already Registered");
        }
        return "register.jsp";
    }

}

/*
*
*  @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> hello(LoginVO loginVO, Model model) {
         String token = loginService.match(loginVO);
         if(token.equalsIgnoreCase("userNotFoundException")){
             model.addAttribute("error", "INVALID USERNAME");
         } else if(token.equalsIgnoreCase("PasswordMismatchException")){
             model.addAttribute("error", "INVALID PASSWORD");
         } else {
             return new ResponseEntity<>("<html>" +
                     "<head>" +
                     "</head>" +
                     "<body>" +
                     "<pre> " +
                     "        LOGIN SUCCESSFUL  <br><br>" +
                     "        YOUR SECURITY TOKEN :<b>" +
                     token +
                     "</b></pre>" +
                     "</body>" +
                     "<html>", HttpStatus.OK);
         }

         return ResponseEntity.badRequest().body("home.jsp");
    }
 */