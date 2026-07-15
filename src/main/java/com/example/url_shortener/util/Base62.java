package com.example.url_shortener.util;

public class Base62 {
    private static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int BASE = CHARACTERS.length();

    public static String encode(long input) {
        StringBuilder sb = new StringBuilder();
        while (input > 0) {
            sb.append(CHARACTERS.charAt((int) (input % BASE)));
            input /= BASE;
        }
        return sb.reverse().toString();
    }
}