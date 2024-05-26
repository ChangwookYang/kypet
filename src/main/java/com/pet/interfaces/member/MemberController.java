package com.pet.interfaces.member;

import com.pet.application.member.port.SignUpPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MemberController {

    private final SignUpPort signUpPort;

    @PostMapping("/v1/member/signUp")
    public ResponseEntity<Void> signUp(@RequestBody SignUpCommand signUpCommand) {

        signUpPort.signUp(signUpCommand.email(), signUpCommand.password(), signUpCommand.nickname());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @PostMapping("/v1/member/signIn")
    public ResponseEntity<Void> signIn(@RequestBody SignUpCommand signUpCommand) {

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
