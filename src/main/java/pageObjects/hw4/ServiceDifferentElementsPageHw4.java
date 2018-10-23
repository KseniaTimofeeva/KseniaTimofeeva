package pageObjects.hw4;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

public class ServiceDifferentElementsPageHw4 {

    @FindBy(css = ".checkbox-row > label.label-checkbox")
    private ElementsCollection checkboxes;

    @FindBy(css = ".checkbox-row > label.label-radio")
    private ElementsCollection radios;

    @FindBy(css = ".colors > select")
    private SelenideElement dropdown;

    @FindBy(css = ".main-content-hg>.uui-button")
    private ElementsCollection buttons;

    @FindBy(css = "div[name='log-sidebar']")
    private SelenideElement rightSection;


    //methods


    //checks
    public void checkCheckboxesExist() {
        checkboxes.shouldHaveSize(4);
        for (SelenideElement checkbox : checkboxes) {
            checkbox.shouldBe(Condition.visible);
        }
    }

    public void checkRadiosExist() {
        radios.shouldHaveSize(4);
        for (SelenideElement radio : radios) {
            radio.shouldBe(Condition.visible);
        }
    }

    public void checkDropdownExist() {
        dropdown.shouldBe(Condition.visible);
    }

    public void checkButtonsExist() {
        buttons.shouldHaveSize(2);
        for (SelenideElement button : buttons) {
            button.shouldBe(Condition.visible);
        }
    }

    public void checkRightSectionIsDisplayed() {
        rightSection.shouldBe(Condition.visible);
    }
}
