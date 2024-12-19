package com.vitor.springsecurity.controller.dto;

public record LoginResponse(String aceessToken, Long expiresIn) {
}
