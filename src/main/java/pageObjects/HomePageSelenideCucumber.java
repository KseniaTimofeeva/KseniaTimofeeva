package pageObjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class HomePageSelenideCucumber {


    @FindBy(css = ".profile-photo")
    private SelenideElement profileButton;

    @FindBy(css = "[id = 'Name']")
    private SelenideElement login;

    @FindBy(css = "[id = 'Password']")
    private SelenideElement password;

    @FindBy(css = ".login [type = 'submit']")
    private SelenideElement submit;

    @FindBy(css = "h3.main-title")
    private SelenideElement mainTitle;

    public HomePageSelenideCucumber() {
        page(this);
    }


    //methods
    @Step
    @When("I'm on the Home Page")
    public void openPage() {
        Selenide.open("https://epam.github.io/JDI/index.html");
    }

    @Step
    @When("I login as user (.+) with password (.+)")
    public void login(String name, String passwd) {
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(passwd);
        submit.click();

    }

    //checks
    @Step
    @Then("The browser title is Home Page")
    public void checkTitle() {
        Assert.assertEquals(getWebDriver().getTitle(), "Home Page");
    }

    @Step
    @Then("The user icon is displayed on the header")
    public void checkUserIcon() {
        profileButton.shouldBe(visible);
    }
}
