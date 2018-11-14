package pageObjects.hw6;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import dto.LogItem;
import enums.Color;
import enums.Element;
import enums.Metal;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import pageObjects.hw6.center.RightSection;
import pageObjects.hw6.commonElements.LeftSection;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Selenide.page;

public class DifferentElements {

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
        page(this);
        rightSection = page(RightSection.class);
        leftSection = page(LeftSection.class);
    }

    //methods
    @Step
    @When("I (un|)select checkboxes:")
    public void selectCheckbox(List<String> checkboxNames) {
        List<Element> checkboxLabels = Element.getListByNames(checkboxNames);
        for (Element checkboxLabel : checkboxLabels) {
            SelenideElement checkbox = findCheckboxFromCheckboxesList(checkboxLabel);
            checkbox.click();
            rightSection.addLog();
        }
    }

    @Step
    @When("I select radio \"(.+)\"")
    public void selectRadio(String radioName) {
        Metal radioLabel = Metal.getByName(radioName);
        SelenideElement radio = findRadioFromList(radioLabel);
        radio.click();
        rightSection.addLog();
    }

    @Step
    @When("I select in dropdown \"(.+)\"")
    public void selectInDropdown(String name) {
        Color dropdownLabel = Color.getByName(name);
        dropdown.click();
        dropdown.selectOption(dropdownLabel.getDisplayName());
        rightSection.addLog();
    }

    private SelenideElement findCheckboxFromCheckboxesList(Element checkboxLabel) {
        return checkboxes.find(Condition.text(checkboxLabel.getDisplayName()));
    }

    private SelenideElement findRadioFromList(Metal radioLabel) {
        return radios.find(Condition.text(radioLabel.getDisplayName()));
    }

    //checks
    @Step
    @And("(\\d+) (checkboxes|radios|buttons) are displayed on \"Different Elements\" page")
    public void checkImages(int expQty, String elementName) {
        ElementsCollection elements;
        switch (elementName) {
            case "checkboxes":
                elements = checkboxes;
                break;
            case "radios":
                elements = radios;
                break;
            case "buttons":
                elements = buttons;
                break;
            default:
                throw new RuntimeException("Unexpected element");
        }
        elements.shouldHaveSize(expQty);
        for (SelenideElement element : elements) {
            element.shouldBe(Condition.visible);
        }
    }

    @Step
    @And("1 dropdown is displayed on \"Different Elements\" page")
    public void checkDropdownExist() {
        dropdown.shouldBe(Condition.visible);
    }

    @Step
    @And("Left section is displayed on \"Different Elements\" page")
    public void checkLeftSectionIsDisplayed() {
        leftSection.checkLeftSectionIsDisplayed();
    }

    @Step
    @And("Right section is displayed on \"Different Elements\" page")
    public void checkRightSectionIsDisplayed() {
        rightSection.checkRightSectionIsDisplayed();
    }

    @Step
    @Then("Log rows are displayed, checkbox name and its status is corresponding to values:")
    public void checkLog(Map<String, String> expected) {
        for (Map.Entry<String, String> entry : expected.entrySet()) {
            checkLoggedNameAndStatusCorrect(Element.getByName(entry.getKey()), Boolean.valueOf(entry.getValue()));
        }
    }

    @Step
    @Then("Log row is displayed, radiobutton name and its status is corresponding to \"(.+)\"")
    public void checkRadiobuttonLog(String name) {
        checkLoggedNameAndStatusCorrect(Metal.getByName(name));
    }

    @Step
    @Then("Log row is displayed, dropdown name and selected value is corresponding to \"(.+)\"")
    public void checkDropdownLog(String name) {
        checkLoggedNameAndStatusCorrect(Color.getByName(name));
    }

    private void checkLoggedNameAndStatusCorrect(Element checkbox, boolean value) {
        rightSection.checkLoggedNameAndStatusCorrect(new LogItem(checkbox.getDisplayName(), String.valueOf(value)));
    }

    private void checkLoggedNameAndStatusCorrect(Metal radio) {
        rightSection.checkLoggedNameAndStatusCorrect(new LogItem(Metal.type(), radio.getDisplayName()));
    }

    private void checkLoggedNameAndStatusCorrect(Color dropdown) {
        rightSection.checkLoggedNameAndStatusCorrect(new LogItem(Color.type(), dropdown.getDisplayName()));
    }
}
