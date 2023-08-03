package ru.hh.tests.web;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static ru.hh.tests.web.WebTestData.*;

public class WebLoginTests extends WebTestBase {
    @Test
    @Tag("login_test")
    void loginViaEmailAndPassword() {
        step("Fill out sign up data and click 'Log in' button", () -> {
            loginPage.clickLogInButtonOnMainPage()
                    .clickLogInWithPasswordButton()
                    .inputEmailAndPasswordToSignUp(userGmail, hhPassword)
                    .clickLogInButtonUnderEmailAndPasswordFields();
        });
        step("Check that the user is authorized by verifying his/her/its name", () -> {
            loginPage.clickProfileIconButton()
                    .checkProfileName(hhUserName);
        });
        step("Logout", () -> {
            loginPage.logOutAccount()
                    .checkThatUserIsUnathorized();
        });
    }
    @Test
    @Tag("login_test")
    void loginViaGoogleAccount() {
        step("Choose authorization via Google account and input all the necessary data", () -> {
            loginPage.clickLogInButtonOnMainPage()
                    .clickGoogleIconToLogIn()
                    .inputGmail(userGmail)
                    .clickNextButton()
                    .inputGooglePassword(userGooglePassword)
                    .clickNextButtonAgain();
        });
        step("Check that the user is authorized by verifying his/her/its name", () -> {
            loginPage.clickProfileIconButton()
                    .checkProfileName(hhUserName);
        });
        step("Logout", () -> {
            loginPage.logOutAccount()
                    .checkThatUserIsUnathorized();
        });
    }
}
