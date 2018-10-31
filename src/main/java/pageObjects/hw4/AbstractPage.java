package pageObjects.hw4;

import enums.PageTitles;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

public abstract class AbstractPage {

    public void checkTitle(PageTitles title) {
        assertEquals(getWebDriver().getTitle(), title.getDisplayName());
    }
}
