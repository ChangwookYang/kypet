package com.pet.interfaces.member;

import io.swagger.v3.oas.annotations.media.Schema;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Schema(description = "Sign up request")
public record SignUpRequest(
        @Schema(description = "email", example = "이메일", requiredMode = REQUIRED)
        String email,
        @Schema(description = "password", example = "비밀번호", requiredMode = REQUIRED)
        String password,
        @Schema(description = "nickname", example = "닉네임", requiredMode = REQUIRED)
        String nickname) {
}
