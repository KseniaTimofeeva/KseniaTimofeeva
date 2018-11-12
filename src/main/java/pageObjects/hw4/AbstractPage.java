package pageObjects.hw4;

import cucumber.api.java.en.Then;
import enums.PageTitles;
import io.qameta.allure.Step;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public abstract class AbstractPage {

    @Step
    @Then("The browser title is (.+)")
    public void checkTitle(PageTitles title) {
        assertEquals(getWebDriver().getTitle(), title.getDisplayName());
    }
}
