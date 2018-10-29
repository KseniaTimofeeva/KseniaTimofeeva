package pageObjects.hw4;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import enums.PageTitles;
import enums.ServiceOptions;
import enums.Users;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class BasePage {

    @FindBy(css = ".profile-photo")
    private SelenideElement profileButton;

    @FindBy(css = "[id = 'Name']")
    private SelenideElement loginField;

    @FindBy(css = "[id = 'Password']")
    private SelenideElement passwordField;

    @FindBy(css = ".login [type = 'submit']")
    private SelenideElement enterButton;

    @FindBy(css = ".profile-photo [ui = 'label']")
    private SelenideElement userName;

    @FindBy(css = ".uui-navigation.nav > li.dropdown > a")
    private SelenideElement headerServiceCategory;

    @FindBy(css = "ul.dropdown-menu > li")
    private ElementsCollection headerServiceCategoryOptions;

    @FindBy(xpath = "//li[@class='menu-title']/a/span[text()='Service']")
    private SelenideElement leftServiceCategory;

    @FindBy(xpath = "//li[@class='menu-title']/a/span[text()='Service']/parent::*/following-sibling::*/li")
    private ElementsCollection leftServiceCategoryOptions;

    @FindBy(css = "ul.uui-navigation.nav > li > ul > li > a[href='different-elements.html']")
    private SelenideElement serviceDifferentElementsOption;

    @FindBy(css = "ul.uui-navigation.nav > li > ul > li > a[href='dates.html']")
    private SelenideElement serviceDatesOption;

    @FindBy(css = "div[name='navigation-sidebar']")
    private SelenideElement leftSection;


    //methods
    public void openPage() {
        Selenide.open("https://epam.github.io/JDI/");
    }

    public void login(Users user) {
        profileButton.click();
        loginField.sendKeys(user.login);
        passwordField.sendKeys(user.password);
        enterButton.click();
    }

    public void chooseHeaderServiceCategory() {
        headerServiceCategory.click();
    }

    public void chooseServiceDifferentElementsOption() {
        serviceDifferentElementsOption.click();
    }

    public void chooseServiceDatesOption() {
        serviceDatesOption.click();
    }


    //checks
    public void checkTitle(PageTitles title) {
        Assert.assertEquals(getWebDriver().getTitle(), title.getDisplayName());
    }

    public void checkUserIsLoggined(Users user) {
        userName.shouldHave(exactText(user.name));
    }

    public void checkHeaderServiceOptions() {
        headerServiceCategoryOptions.shouldHaveSize(ServiceOptions.values().length);
        headerServiceCategoryOptions.shouldHave(
                CollectionCondition.exactTexts(ServiceOptions.displayNames()));
    }

    public void checkLeftServiceOptions() {
        leftServiceCategory.click();
        leftServiceCategoryOptions.shouldHaveSize(ServiceOptions.values().length);
        leftServiceCategoryOptions.shouldHave(
                CollectionCondition.exactTexts(ServiceOptions.displayNames()));
    }

    public void checkLeftSectionIsDisplayed() {
        leftSection.shouldBe(Condition.visible);
    }

}
