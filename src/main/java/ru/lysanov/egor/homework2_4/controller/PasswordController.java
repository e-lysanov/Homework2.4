package ru.lysanov.egor.homework2_4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.lysanov.egor.homework2_4.exceptions.WrongLoginException;
import ru.lysanov.egor.homework2_4.exceptions.WrongPasswordsException;
import ru.lysanov.egor.homework2_4.exceptions.WrongPasswordException;
import ru.lysanov.egor.homework2_4.service.PasswordService;

@RestController
public class PasswordController {

    private final PasswordService passwordService;
    public  PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }


    @GetMapping(path = "/checkPassword")
    public  String checkPassword(@RequestParam("login") String login, @RequestParam("password") String password, @RequestParam("confirmPassword") String confirmPassword) {
        try {
            return passwordService.checkPassword(login, password, confirmPassword);
        } catch (WrongLoginException exception) {
            exception.printStackTrace();
            return "Неправильный формат логина";
        } catch (WrongPasswordException exception) {
            exception.printStackTrace();
            return "Неправильный формат пароля";
        } catch (WrongPasswordsException exception) {
            exception.printStackTrace();
            return "Пароли не совпадают";
        }
    }
}
