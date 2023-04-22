package ru.lysanov.egor.homework2_4.service;

public interface PasswordService {
    String checkPassword(String login, String password, String confirmPassword);
}
