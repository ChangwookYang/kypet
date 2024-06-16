package com.pet.application.user.port.in;

public interface UserUseCase {

    SignUpResult signUp(String email, String password, String nickname);

}
