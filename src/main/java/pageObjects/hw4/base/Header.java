package pageObjects.hw4.base;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.ServiceOptions;
import enums.Users;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.exactText;

public class Header {

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
    private SelenideElement serviceCategory;

    @FindBy(css = "ul.dropdown-menu > li")
    private ElementsCollection serviceCategoryOptions;

    @FindBy(css = "ul.uui-navigation.nav > li > ul > li > a[href='different-elements.html']")
    private SelenideElement serviceDifferentElementsOption;

    @FindBy(css = "ul.uui-navigation.nav > li > ul > li > a[href='dates.html']")
    private SelenideElement serviceDatesOption;

    //methods
    public void login(Users user) {
        profileButton.click();
        loginField.sendKeys(user.login);
        passwordField.sendKeys(user.password);
        enterButton.click();
    }

    public void chooseServiceCategory() {
        serviceCategory.click();
    }

    public void chooseServiceDifferentElementsOption() {
        serviceDifferentElementsOption.click();
    }

    public void chooseServiceDatesOption() {
        serviceDatesOption.click();
    }

    //checks
    public void checkUserIsLogged(Users user) {
        userName.shouldHave(exactText(user.name));
    }

    public void checkServiceOptions() {
        serviceCategoryOptions.shouldHaveSize(ServiceOptions.values().length);
        serviceCategoryOptions.shouldHave(CollectionCondition.exactTexts(ServiceOptions.displayNames()));
    }
}
