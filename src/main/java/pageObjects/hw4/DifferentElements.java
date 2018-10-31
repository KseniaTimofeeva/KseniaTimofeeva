package pageObjects.hw4;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import dto.LogItem;
import enums.CheckboxLabels;
import enums.DropdownLabels;
import enums.RadioLabels;
import org.openqa.selenium.support.FindBy;
import pageObjects.hw4.base.LeftSection;
import pageObjects.hw4.center.RightSection;

public class DifferentElements extends AbstractPage {

    @FindBy(css = ".checkbox-row > label.label-checkbox")
    private ElementsCollection checkboxes;

    @FindBy(css = ".checkbox-row > label.label-radio")
    private ElementsCollection radios;

    @FindBy(css = ".colors > select")
    private SelenideElement dropdown;

    @FindBy(css = ".main-content-hg>.uui-button")
    private ElementsCollection buttons;

    private RightSection rightSection;
    private LeftSection leftSection;

    public DifferentElements() {
        rightSection = Selenide.page(RightSection.class);
        leftSection = Selenide.page(LeftSection.class);
    }

    //methods
    public void selectCheckbox(CheckboxLabels... checkboxLabels) {
        for (CheckboxLabels checkboxLabel : checkboxLabels) {
            SelenideElement checkbox = findCheckboxFromCheckboxesList(checkboxLabel);
            checkbox.click();
        }
    }

    public void selectRadio(RadioLabels radioLabel) {
        SelenideElement radio = findRadioFromList(radioLabel);
        radio.click();
    }

    public void selectInDropdown(DropdownLabels dropdownLabel) {
        dropdown.click();
        dropdown.selectOption(dropdownLabel.getDisplayName());
    }

    private SelenideElement findCheckboxFromCheckboxesList(CheckboxLabels checkboxLabel) {
        return checkboxes.find(Condition.text(checkboxLabel.getDisplayName()));
    }

    private SelenideElement findRadioFromList(RadioLabels radioLabel) {
        return radios.find(Condition.text(radioLabel.getDisplayName()));
    }

    //checks
    public void checkCheckboxesExist() {
        checkboxes.shouldHaveSize(CheckboxLabels.values().length);
        for (SelenideElement checkbox : checkboxes) {
            checkbox.shouldBe(Condition.visible);
        }
    }

    public void checkRadiosExist() {
        radios.shouldHaveSize(RadioLabels.values().length);
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

    public void checkLeftSectionIsDisplayed() {
        leftSection.checkLeftSectionIsDisplayed();
    }

    public void checkCheckboxIsChecked(CheckboxLabels... checkboxLabels) {
        for (CheckboxLabels checkboxLabel : checkboxLabels) {
            SelenideElement checkbox = findCheckboxFromCheckboxesList(checkboxLabel).$("input");
            checkbox.shouldBe(Condition.checked);
            rightSection.addLog();
        }
    }

    public void checkRadioIsChecked(RadioLabels radioLabel) {
        SelenideElement radio = findRadioFromList(radioLabel).$("input");
        radio.shouldBe(Condition.checked);
        rightSection.addLog();
    }

    public void checkDropdownIsSelected(DropdownLabels dropdownLabel) {
        dropdown.getSelectedOption().shouldHave(Condition.text(dropdownLabel.getDisplayName()));
        rightSection.addLog();
    }

    public void checkCheckboxIsUnchecked(CheckboxLabels... checkboxLabels) {
        for (CheckboxLabels checkboxLabel : checkboxLabels) {
            SelenideElement checkbox = findCheckboxFromCheckboxesList(checkboxLabel).$("input");
            checkbox.shouldNotBe(Condition.checked);
            rightSection.addLog();
        }
    }

    public void checkRightSectionIsDisplayed() {
        rightSection.checkRightSectionIsDisplayed();
    }

    public void checkLoggedNameAndStatusCorrect(CheckboxLabels checkbox, boolean value) {
        rightSection.checkLoggedNameAndStatusCorrect(new LogItem(checkbox.getDisplayName(), String.valueOf(value)));
    }

    public void checkLoggedNameAndStatusCorrect(RadioLabels radio) {
        rightSection.checkLoggedNameAndStatusCorrect(new LogItem(RadioLabels.type(), radio.getDisplayName()));
    }

    public void checkLoggedNameAndStatusCorrect(DropdownLabels dropdown) {
        rightSection.checkLoggedNameAndStatusCorrect(new LogItem(DropdownLabels.type(), dropdown.getDisplayName()));
    }
}
