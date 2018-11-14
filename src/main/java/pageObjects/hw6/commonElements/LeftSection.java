package pageObjects.hw6.commonElements;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

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
    public void checkServiceOptions(List<String> options) {
        serviceCategoryOptions.shouldHaveSize(options.size());
        serviceCategoryOptions.shouldHave(CollectionCondition.exactTexts(options));
    }

    public void checkLeftSectionIsDisplayed() {
        leftSection.shouldBe(Condition.visible);
    }
}
