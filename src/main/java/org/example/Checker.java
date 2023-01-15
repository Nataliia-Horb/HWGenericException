package org.example;

import java.util.regex.Pattern;

//    Exceptions. Проверка логина и пароля
//        Создать статический метод который принимает на вход три параметра: login, password и confirmPassword.
//        Login должен содержать только латинские буквы, цифры и знак подчеркивания.
//                Длина login должна быть меньше 20 символов.
//                Если login не соответствует этим требованиям, необходимо выбросить WrongLoginException.

//        Password должен содержать только латинские буквы, цифры и знак подчеркивания.
//                Длина password должна быть меньше 20 символов. Также password и confirmPassword должны быть равны.
//                Если password не соответствует этим требованиям, необходимо выбросить WrongPasswordException.
//
//        WrongPasswordException и WrongLoginException - пользовательские классы исключения с двумя конструкторами – один по умолчанию,
//                второй принимает сообщение исключения и передает его в конструктор класса Exception.
//        Обработка исключений проводится внутри метода.
//                Используем multi-catch block. Метод возвращает true, если значения верны или false в другом случае.
//
public class Checker {
    private static final Pattern patternLetter = Pattern.compile("[A-Za-z]");
    private static Pattern patternNumber = Pattern.compile("[0-9]");
    private static Pattern patternUnterscores = Pattern.compile("_");
    private static Pattern antiPattern = Pattern.compile("\\W+");


    public static boolean check(String login, String password, String confirmPassword) {
        try {
            checkInvalidLoginException(login);
            checkInvalidPasswordException(password, confirmPassword);

        } catch (WrongLoginException | WrongPasswordException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private static void checkInvalidLoginException(String login) throws WrongLoginException {
        if (login.isEmpty()) {
            throw new WrongLoginException("The some field is empty");
        }
        if (login.length() > 20) {
            throw new WrongLoginException("Login length is too long");
        }
        if (!checkAllPatterns(login)) {
            throw new WrongLoginException("Login contains invalid characters");
        }
    }

    private static void checkInvalidPasswordException(String password, String confirmPassword) throws WrongPasswordException {

        if (password.isEmpty() || confirmPassword.isEmpty()) {
            throw new WrongPasswordException("The some field is empty");
        }
        if (password.length() > 20 || confirmPassword.length() > 20) {
            throw new WrongPasswordException("Password length is too long");
        }
        if (!checkAllPatterns(password)) {
            throw new WrongPasswordException("Password contains invalid characters");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Passwords do not match");
        }
    }

    private static boolean checkAllPatterns(String text) {
        return (patternLetter.matcher(text).find() && patternNumber.matcher(text).find()
                && patternUnterscores.matcher(text).find() && !antiPattern.matcher(text).find());
    }
}
