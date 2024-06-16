package com.pet.infrastructure.user;

import com.pet.application.domain.user.User;
import com.pet.application.user.port.out.UserPort;
import com.pet.interfaces.exception.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.pet.infrastructure.user.UserException.NOT_EXIST_USER;

@Repository
@RequiredArgsConstructor
public class UserPersistenceAdapter implements UserPort {
    private final UserRepository userRepository;

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email).map(UserEntity::toUser).orElseThrow(() -> new ApiException(NOT_EXIST_USER));
    }

    @Override
    public User signUp(String email, String password, String nickname) {
        final UserEntity userEntity = userRepository.save(UserEntity.builder()
                .email(email)
                .password(password)
                .nickname(nickname)
                .build());
        return userEntity.toUser();
    }
}
