package ru.lysanov.egor.homework2_4.service;

import org.springframework.stereotype.Service;
import ru.lysanov.egor.homework2_4.exceptions.WrongLoginException;
import ru.lysanov.egor.homework2_4.exceptions.WrongPasswordsException;
import ru.lysanov.egor.homework2_4.exceptions.WrongPasswordException;

import java.util.regex.Pattern;


@Service
public class PasswordServiceImpl implements PasswordService {

    @Override
    public String checkPassword(String login, String password, String confirmPassword) {
        if (!Pattern.matches("^[a-zA-Z0-9_]{1,20}$", login)) {
            throw new WrongLoginException("Неправильный формат логина");
        }
        if (!Pattern.matches("^[a-zA-Z0-9_]{1,19}$", password)) {
            throw new WrongPasswordException("Неправильный формат пароля");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordsException("Пароли не совпадают");
        }
        return "true";
    }
}
