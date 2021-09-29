package com.hexaview.loginMs.controller;
import com.hexaview.loginMs.request.LoginVO;
import com.hexaview.loginMs.request.StudentInfoListVO;
import com.hexaview.loginMs.request.StudentInfoVO;
import com.hexaview.loginMs.service.LoginService;
import com.hexaview.loginMs.service.RegisterService;
import com.hexaview.loginMs.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class LoginController {
    @Autowired
    LoginService loginService;

    @Autowired
    RegisterService registerService;

    @Autowired
    StudentService studentService;

    @GetMapping("/")
    public String index(Model model) {
        return "home.jsp";
    }

    @PostMapping(value = "/login")
    public String login(LoginVO loginVO, Model model) {
        String token = loginService.validate(loginVO);

        if (token.equalsIgnoreCase("userNotFoundException")) {
            model.addAttribute("error", "INVALID USERNAME");
            log.error("Username doesn't exist");
        } else if (token.equalsIgnoreCase("PasswordMismatchException")) {
            log.error("password mismatched");
            model.addAttribute("error", "INVALID PASSWORD");
        } else {
            model.addAttribute("username", loginVO.getUsername());
            model.addAttribute("token", token);
            log.info("Login Successful..Redirecting to home page");
            return "disp.jsp";
        }
        return "home.jsp";
    }

    @RequestMapping(value = "/register")
    public String registerPage() {
        return "register.jsp";
    }

    @PostMapping(value = "/register")
    public String register(LoginVO loginVO, Model model) {
        log.info("Request For User Registration ");
        boolean success = registerService.register(loginVO);
        if (success) {
            model.addAttribute("msg", "Successfully Registered");
        } else {
            model.addAttribute("error", "User already Registered");
        }
        log.info("User registered Succesfully.. Redirecting to login page");
        return "home.jsp";
    }

    @GetMapping(value = "/allstudents")
    public ModelAndView getAllStudents(){
        ModelAndView mvc = new ModelAndView("displayTable.jsp");
        StudentInfoListVO studentInfoListVO = studentService.getAllStudents();
        mvc.addObject("StudentList", studentInfoListVO);
        return mvc;
    }

    @GetMapping(value = "/student/")
    public ModelAndView getStudent(Integer studentId){
        ModelAndView mvc = new ModelAndView("displayTable.jsp");
        StudentInfoListVO studentInfoListVO = studentService.getStudentByID(studentId);
        mvc.addObject("StudentList", studentInfoListVO);
        return mvc;
    }


}