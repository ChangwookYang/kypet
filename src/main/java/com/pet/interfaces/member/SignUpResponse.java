package com.pet.interfaces.member;

import io.swagger.v3.oas.annotations.media.Schema;

import static io.swagger.v3.oas.annotations.media.Schema.RequiredMode.REQUIRED;

@Schema(description = "Sign up response")
public record SignUpResponse(

        @Schema(description = "user id", example = "유저 ID", requiredMode = REQUIRED)
        Long userId,
        @Schema(description = "email", example = "이메일", requiredMode = REQUIRED)
        String email,
        @Schema(description = "nickname", example = "닉네임", requiredMode = REQUIRED)
        String nickname) {
}
