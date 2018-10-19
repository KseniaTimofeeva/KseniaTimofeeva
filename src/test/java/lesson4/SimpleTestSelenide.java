package lesson4;

import base.SelenideTestBase;
import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.SelenideElement;
import enums.Users;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static java.lang.System.setProperty;
import static org.testng.Assert.assertEquals;

public class SimpleTestSelenide extends SelenideTestBase {

    @Test
    public void simpleTest() {
        setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        //2 Navigate
        open("https://epam.github.io/JDI/index.html");

        //3 Assert Title
        assertEquals(getWebDriver().getTitle(), "Home Page");

        //4 Login
        $(".profile-photo").click();
        $("[id = 'Name']").sendKeys(Users.PITER_CHAILOVSKII.login);
        $("[id = 'Password']").sendKeys(Users.PITER_CHAILOVSKII.password);
        $(".login [type = 'submit']").click();

        $$(By.xpath(""));

        //5 Check main title
        SelenideElement mainTitle = $("h3.main-title");
        mainTitle.shouldBe(visible);
        mainTitle.shouldHave(text("EPAM FRAMEWORK WISHES…"));

        //6 Check 4 images
        $$(By.xpath("")).shouldHaveSize(4);
        $$(By.xpath("")).shouldBe(CollectionCondition.sizeLessThan(5));

    }
}
