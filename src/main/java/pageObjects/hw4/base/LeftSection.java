package pageObjects.hw4.base;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import enums.ServiceOptions;
import org.openqa.selenium.support.FindBy;

public class LeftSection {

    @FindBy(css = "div[name='navigation-sidebar']")
    private SelenideElement leftSection;

    @FindBy(xpath = "//li[@class='menu-title']/a/span[text()='Service']")
    private SelenideElement serviceCategory;

    @FindBy(xpath = "//li[@class='menu-title']/a/span[text()='Service']/parent::*/following-sibling::*/li")
    private ElementsCollection serviceCategoryOptions;

    //methods
    public void chooseServiceCategory() {
        serviceCategory.click();
    }

    //checks
    public void checkServiceOptions() {
        serviceCategoryOptions.shouldHaveSize(ServiceOptions.values().length);
        serviceCategoryOptions.shouldHave(CollectionCondition.exactTexts(ServiceOptions.displayNames()));
    }

    public void checkLeftSectionIsDisplayed() {
        leftSection.shouldBe(Condition.visible);
    }
}
