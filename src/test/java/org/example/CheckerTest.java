package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class CheckerTest {

    @ParameterizedTest
    @DisplayName("Validate user input: ")
    @CsvFileSource(resources = "/paramCorrect.csv",delimiter = ' ',numLinesToSkip = 1)
    void checkCorrectValuesTest(String login, String password, String confirmPassword) {
        assertTrue(Checker.check(login,password,confirmPassword));
    }

    @ParameterizedTest
    @DisplayName("Incorrect data from the user: ")
    @CsvFileSource(resources = "/paramIncorrect.csv",delimiter = ' ',numLinesToSkip = 1)
    void checkInvalidTest(String login, String password, String confirmPassword) {
        assertFalse(Checker.check(login, password, confirmPassword));
    }

//    @Test
//    void checkException() {
//        Exception exception = assertThrows(WrongPasswordException.class, () ->
//                Checker.check("123_k", "123_k123", "123_k123*"));
//
//        String actualMessage = exception.getMessage();
//        System.out.println(actualMessage);
//        assertEquals("Passwords do not match", actualMessage);
//    }

}
