package ru.hh.tests.web;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static ru.hh.tests.web.WebTestData.*;

public class WebJobSearchTests extends WebTestBase {
    @Test
    @Tag("job_search")
    void successfulSimpleJobSearch() {
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
        step("Choose job search city", () -> {
            jobSearchPage.clickJobSearchLocationSwitcher()
                    .chooseCity(city);
        });
        step("Make job query", () -> {
            jobSearchPage.inputQueryIntoSearchField(searchQuery)
                    .clickSearchFieldFindButton();
        });
        step("Check search results", () -> {
            jobSearchPage.checkSearchResultsHeader(searchQuery, city)
                    .checkSearchResults(searchQuery);
        });
        step("Logout", () -> {
            loginPage.clickProfileIconButton()
                    .logOutAccount()
                    .checkThatUserIsUnathorized();
        });
    }

    @Test
    @Tag("job_search")
    void successfulAdvancedJobSearch() {
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
        step("Navigate to advanced search", () -> {
            jobSearchPage.clickAdvancedSearchButton();
        });
        step("Set advanced search parameters", () -> {
            jobSearchPage.chooseSpecialization()
                    .chooseProfession();
        });
    }
}
