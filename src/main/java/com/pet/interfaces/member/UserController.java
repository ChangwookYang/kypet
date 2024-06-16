package com.pet.interfaces.member;

import com.pet.application.domain.user.User;
import com.pet.application.user.port.in.SignUpResult;
import com.pet.application.user.port.in.UserUseCase;
import com.pet.interfaces.response.WebApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Tag(name = "User API")
public class UserController {

    private final UserUseCase userUseCase;

    @Operation(summary = "회원가입 API", description = "회원가입한다.")
    @ApiResponses(value = {@ApiResponse(description = "회원가입 정보 리턴", useReturnTypeSchema = true)})
    @PostMapping("/signUp")
    public WebApiResponse<SignUpResponse> signUp(@RequestBody SignUpRequest request) {

        final SignUpResult signUpResult = userUseCase.signUp(request.email(), request.password(), request.nickname());

        return WebApiResponse.success(new SignUpResponse(signUpResult.userId(), signUpResult.email(), signUpResult.nickname()));
    }

    @Operation(summary = "회원 로그인 API", description = "회원 로그인한다.")
    @ApiResponses(value = {@ApiResponse(description = "회원 로그인 정보 리턴", useReturnTypeSchema = true)})
    @PostMapping("/signIn")
    public WebApiResponse<Void> signIn(@RequestBody SignInRequest signInRequest) {

        return WebApiResponse.success();
    }
}
