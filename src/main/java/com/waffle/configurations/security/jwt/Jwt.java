package com.waffle.configurations.security.jwt;

public class Jwt {

    public static JwtProvider provider() {
        return new JwtProvider();
    }

    public static JwtUtils utils() {
        return new JwtUtils();
    }
}
