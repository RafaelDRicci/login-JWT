package com.teste.encriptpassword;

import com.teste.encriptpassword.model.UserModel;
import com.teste.encriptpassword.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception{

        UserModel user = new UserModel();
        user.setUsername("user");
        user.setPassword(passwordEncoder.encode("user"));
        userRepository.save(user);

        UserModel admin = new UserModel();
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("admin"));
        userRepository.save(admin);


    }

}
