package com.example.neohackproject.utils;

public class AuthorizationEx extends RuntimeException{
    public AuthorizationEx(String message) {
        super(message);
    }

    public AuthorizationEx() {
    }
}
