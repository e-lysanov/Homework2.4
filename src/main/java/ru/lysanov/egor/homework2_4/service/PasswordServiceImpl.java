package ru.lysanov.egor.homework2_4.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import ru.lysanov.egor.homework2_4.exceptions.WrongLoginException;
import ru.lysanov.egor.homework2_4.exceptions.WrongPasswordException;
import ru.lysanov.egor.homework2_4.exceptions.WrongPasswordLenghtException;

@Service
public class PasswordServiceImpl implements PasswordService {
    @Override
    public String checkPassword(String login, String password, String confirmPassword) {
        if (login.length() > 20) {
            throw new WrongLoginException();
        }
        if (password.length() > 20) {
            throw new WrongPasswordLenghtException();
        }
        if (password.equals(confirmPassword) == false) {
            throw new WrongPasswordException();
        }
        return "true";
    }
}
