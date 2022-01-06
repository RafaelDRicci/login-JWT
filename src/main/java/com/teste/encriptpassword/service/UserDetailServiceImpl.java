package com.teste.encriptpassword.service;

import com.teste.encriptpassword.data.UserDataDetail;
import com.teste.encriptpassword.model.UserModel;
import com.teste.encriptpassword.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@AllArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<UserModel> userModelOptional = userRepository.findByUsername(username);

        if(userModelOptional.isEmpty()){
            throw new UsernameNotFoundException("Usuário "+username+" não encontrado");
        }

        return new UserDataDetail(userModelOptional);
    }
}
