package ru.hh.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    SelenideElement
        logInButtonOnMainPage = $("[data-qa='login']"),
        logInWithPasswordButton = $("[data-qa='expand-login-by-password']"),
        emailSignUpField = $("[data-qa='login-input-username']"),
        passwordSignUpField = $("[data-qa='login-input-password']"),
        logInButtonUnderEmailAndPasswordFields = $("[data-qa='account-login-submit']"),
        profileIconButton = $("[data-qa='mainmenu_applicantProfile']"),
        profileName = $("[data-qa='mainmenu_applicantInfo']"),
        logOutButton = $("[data-qa='mainmenu_logoffUser']"),
        googleIconToLogInWith = $("[data-qa='account-login-social-gplus']"),
        googleAccountEmailOrPhoneField = $("#identifierId"),
        googleIDNextButton = $("#identifierNext"),
        googlePassword = $(byName("Passwd")),
        googlePasswordNextButton = $("#passwordNext");


    public LoginPage clickLogInButtonOnMainPage() {
        logInButtonOnMainPage.click();
        return this;
    }
    public LoginPage clickLogInWithPasswordButton() {
        logInWithPasswordButton.click();
        return this;
    }
    public LoginPage inputEmailAndPasswordToSignUp(String email, String password) {
        emailSignUpField.setValue(email);
        passwordSignUpField.setValue(password);
        return this;
    }
    public LoginPage clickLogInButtonUnderEmailAndPasswordFields() {
        logInButtonUnderEmailAndPasswordFields.click();
        return this;
    }
    public LoginPage clickProfileIconButton() {
        profileIconButton.click();
        return this;
    }
    public LoginPage checkProfileName(String hhUserName) {
        String profileNameParced = profileName.getText();
        assert (profileNameParced).equals(hhUserName);
        System.out.println(profileNameParced);
        return this;
    }
    public LoginPage logOutAccount() {
        logOutButton.click();
        return this;
    }
    public LoginPage checkThatUserIsUnathorized() {
        logInButtonOnMainPage.should(appear);
        return this;
    }
    public LoginPage clickGoogleIconToLogIn() {
        googleIconToLogInWith.click();
        return this;
    }
    public LoginPage inputGmail(String gmail) {
        googleAccountEmailOrPhoneField.setValue(gmail);
        return this;
    }
    public LoginPage clickNextButton() {
        googleIDNextButton.click();
        return this;
    }
    public LoginPage inputGooglePassword(String gPassword) {
        googlePassword.setValue(gPassword);
        return this;
    }
    public LoginPage clickNextButtonAgain() {
        googlePasswordNextButton.click();
        return this;
    }
}
