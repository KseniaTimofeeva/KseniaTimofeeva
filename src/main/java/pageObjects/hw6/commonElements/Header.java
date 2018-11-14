package pageObjects.hw6.commonElements;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.ServiceOptions;
import enums.Users;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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

    @FindBy(css = "ul.uui-navigation.nav > li > ul > li > a[href='user-table.html']")
    private SelenideElement serviceUserTableOption;

    @FindBy(css = "ul.uui-navigation.nav > li > ul > li > a[href='dates.html']")
    private SelenideElement serviceDatesOption;

    //methods
    public void login(String userName) {
        Users user = Users.getByName(userName);
        profileButton.click();
        loginField.sendKeys(user.login);
        passwordField.sendKeys(user.password);
        enterButton.click();
    }

    public void chooseHeaderServiceCategory() {
        serviceCategory.click();
    }

    public void chooseServiceOption(ServiceOptions option) {
        switch (option) {
            case DIFFERENT_ELEMENTS:
                serviceDifferentElementsOption.click();
                break;
            case USER_TABLE:
                serviceUserTableOption.click();
                break;
            default:
                throw new RuntimeException("Unexpected Service option");
        }
    }

    @Step
    public void chooseServiceDatesOption() {
        serviceDatesOption.click();
    }

    //checks
    public void checkUserIsLogged(String name) {
        userName.shouldHave(exactText(name));
    }

    public void checkServiceOptions(List<String> options) {
        serviceCategoryOptions.shouldHaveSize(options.size());
        serviceCategoryOptions.shouldHave(CollectionCondition.exactTexts(options));
    }
}
