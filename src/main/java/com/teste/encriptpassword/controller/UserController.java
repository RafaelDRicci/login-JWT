package com.teste.encriptpassword.controller;

import com.teste.encriptpassword.model.UserModel;
import com.teste.encriptpassword.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserController() {
    }

    @GetMapping
    public ResponseEntity<List<UserModel>> listAll(){
        return ResponseEntity.ok(userRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserModel>> findById(@PathVariable long id){
        return ResponseEntity.ok(userRepository.findById(id));
    }

    @GetMapping("/{userName}/userName")
    public ResponseEntity<Optional<UserModel>> findByUserName(@PathVariable String userName){
        return ResponseEntity.ok(userRepository.findByUsername(userName));
    }

    @GetMapping("/validarSenha")
    public ResponseEntity<Boolean> validatePassword(@RequestParam String userName, @RequestParam String password){

        Optional<UserModel> userModel = userRepository.findByUsername(userName);
        if(userModel.isEmpty()){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(false);
        }

        boolean valid = passwordEncoder.matches(password, userModel.get().getPassword());
        HttpStatus status = (valid) ? HttpStatus.UNAUTHORIZED : HttpStatus.OK;
        return ResponseEntity.status(status).body(valid);
    }

    @PostMapping
    public ResponseEntity<UserModel> save(@RequestBody UserModel userModel){
        userModel.setPassword(passwordEncoder.encode(userModel.getPassword()));
        return ResponseEntity.ok(userRepository.save(userModel));
    }

}
