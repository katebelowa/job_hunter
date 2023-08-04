package ru.hh.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class JobSearchPage {
    SelenideElement
        geographicLocationsSwitcher = $("[data-qa='mainmenu_areaSwitcher']"),
        searchByCityField = $("[data-qa='area-search-input']"),
        citySuggested = $("[data-qa='area-switcher-autocomplete-city']"),
        searchFieldOnMainPage = $("[data-qa='search-input']"),
        searchFieldFindButton = $("[data-qa='search-button']"),
        searchResultsHeader = $("[data-qa='vacancies-catalog-header']"),
        searchResults = $("#a11y-main-content"),
        advancedSearchButton = $("[data-qa='advanced-search']"),
        specializationsChoice = $("[data-qa='resumesearch__profroles-switcher']"),
        itSpecialization = $("[data-qa='bloko-tree-selector-toogle-node bloko-tree-selector-toogle-node-category-11']"),
        profession = $("[data-qa='bloko-tree-selector-item-text bloko-tree-selector-item-text-124']"),
        chooseProfessionButton = $("[data-qa='bloko-tree-selector-popup-submit']");

    public JobSearchPage clickJobSearchLocationSwitcher() {
        geographicLocationsSwitcher.click();
        return this;
    }
    public JobSearchPage chooseCity(String city) {
        searchByCityField.setValue(city).hover();
        citySuggested.should(appear).click();
        return this;
    }
    public JobSearchPage inputQueryIntoSearchField(String searchQuery) {
        searchFieldOnMainPage.setValue(searchQuery);
        return this;
    }
    public JobSearchPage clickSearchFieldFindButton() {
        searchFieldFindButton.click();
        return this;
    }
    public JobSearchPage checkSearchResultsHeader(String searchQuery, String city) {
        String searchResultsValue = searchResultsHeader.getText();
        searchResultsHeader.shouldBe(visible).shouldHave(text(searchQuery), text(city));
        System.out.println(searchResultsValue);
        return this;
    }
    public JobSearchPage checkSearchResults(String searchQuery) {
        searchResults.shouldHave(text(searchQuery));
        return this;
    }
    public JobSearchPage clickAdvancedSearchButton() {
        advancedSearchButton.click();
        return this;
    }
    public JobSearchPage chooseSpecialization() {
        specializationsChoice.click();
        itSpecialization.click();
        return this;
    }
    public JobSearchPage chooseProfession() {
        profession.click();
        chooseProfessionButton.click();
        return this;
    }
}
