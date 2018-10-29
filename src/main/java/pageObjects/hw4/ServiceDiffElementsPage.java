package pageObjects.hw4;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import enums.CheckboxLabels;
import enums.DropdownLabels;
import enums.RadioLabels;
import org.openqa.selenium.support.FindBy;
import utils.LogFactory;

import java.util.ArrayList;
import java.util.List;

public class ServiceDiffElementsPage {

    @FindBy(css = ".checkbox-row > label.label-checkbox")
    private ElementsCollection checkboxes;

    @FindBy(css = ".checkbox-row > label.label-radio")
    private ElementsCollection radios;

    @FindBy(css = ".colors > select")
    private SelenideElement dropdown;

    @FindBy(css = ".main-content-hg>.uui-button")
    private ElementsCollection buttons;

    private RightPanel rightPanel;

    private List<String> clickLog = new ArrayList<>();


    public ServiceDiffElementsPage() {
        rightPanel = Selenide.page(RightPanel.class);
    }


    //methods
    public void selectCheckbox(CheckboxLabels checkboxLabel) {
        SelenideElement checkbox = findCheckboxFromCheckboxesList(checkboxLabel);
        checkbox.click();
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

    private void addLog(Object element, Object value) {
        clickLog.add(LogFactory.createLog(element, value));

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

    public void checkCheckboxIsChecked(CheckboxLabels checkboxLabel) {
        SelenideElement checkbox = findCheckboxFromCheckboxesList(checkboxLabel).$("input");
        checkbox.shouldBe(Condition.checked);
        addLog(checkboxLabel, true);
    }

    public void checkRadioIsChecked(RadioLabels radioLabel) {
        SelenideElement radio = findRadioFromList(radioLabel).$("input");
        radio.shouldBe(Condition.checked);
        addLog(radioLabel, true);
    }

    public void checkDropdownIsSelected(DropdownLabels dropdownLabel) {
        dropdown.getSelectedOption().shouldHave(Condition.text(dropdownLabel.getDisplayName()));
        addLog(dropdownLabel, true);
    }

    public void checkCheckboxIsUnchecked(CheckboxLabels checkboxLabel) {
        SelenideElement checkbox = findCheckboxFromCheckboxesList(checkboxLabel).$("input");
        checkbox.shouldNotBe(Condition.checked);
        addLog(checkboxLabel, false);
    }

    public void checkRightSectionIsDisplayed() {
        rightPanel.checkRightSectionIsDisplayed();
    }

    public void checkLogRowsDisplayed() {
        rightPanel.checkLogRowsDisplayed(clickLog);
    }

    public void checkLoggedNameAndStatusCorrect() {
        rightPanel.checkLoggedNameAndStatusCorrect(clickLog);
    }
}
