package com.pet.interfaces.member;

public record SignUpCommand(String email, String password, String nickname) {
}
