package pageObjects.hw6;

import cucumber.api.java.en.Then;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public class BasePage {

    public BasePage() {
        page(this);
    }

    @Step
    @Then("The browser title is \"(.+)\"")
    public void checkTitle(String title) {
        assertEquals(getWebDriver().getTitle(), title);
    }

    @Then("\"(.+)\" page is opened")
    public void checkPageIsOpened(String title) {
        checkTitle(title);
    }
}
