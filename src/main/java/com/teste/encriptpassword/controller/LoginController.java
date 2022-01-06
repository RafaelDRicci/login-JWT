package com.teste.encriptpassword.controller;

import com.teste.encriptpassword.model.UserModel;
import com.teste.encriptpassword.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginController {

    @Autowired
    private UserRepository userRepository;

/*    @GetMapping("login/screen")
    public String index(){
        return "login/index";
    }*/

}
