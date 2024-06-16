package com.pet.application.user.port.out;

import com.pet.application.domain.user.User;

public interface UserPort {
    User findByEmail(String email);
    User signUp(String email, String password, String nickname);
}
