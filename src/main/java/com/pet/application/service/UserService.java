package com.pet.application.service;

import com.pet.application.domain.user.User;
import com.pet.application.user.port.in.SignUpResult;
import com.pet.application.user.port.in.UserUseCase;
import com.pet.application.user.port.out.UserPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserService implements UserUseCase {

    private final UserPort userPort;
    private final PasswordEncoder passwordEncoder;

    @Override
    public SignUpResult signUp(String email, String password, String nickname) {

        User user = userPort.signUp(
                email,
                passwordEncoder.encode(password),
                nickname);

        return new SignUpResult(user.userId(), user.email(), user.nickname());
    }
}
