package pageObjects.hw6;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.Transpose;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import pageObjects.hw6.center.RightSection;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.page;

public class UserTable {

    @FindBy(css = "#user-table > tbody > tr > td:nth-child(1)")
    private ElementsCollection numberColumn;

    @FindBy(css = "#user-table > tbody > tr > td:nth-child(2) > select")
    private ElementsCollection typeColumn;

    @FindBy(css = "#user-table > tbody > tr > td:nth-child(3)")
    private ElementsCollection nameColumn;

    @FindBy(css = "#user-table > tbody > tr > td:nth-child(4) > img")
    private ElementsCollection imageColumn;

    @FindBy(css = "#user-table > tbody > tr > td:nth-child(4) span")
    private ElementsCollection descriptionColumn;

    @FindBy(css = "#user-table > tbody > tr > td:nth-child(4) input")
    private ElementsCollection checkboxesColumn;

    @FindBy(css = "#user-table tr")
    private ElementsCollection rows;

    private RightSection rightSection;

    public UserTable() {
        page(this);
        rightSection = page(RightSection.class);
    }

    //methods
    @Step
    @When("I select 'vip' checkbox for \"(.+)\"")
    public void selectVipCheckbox(String name) {
        rows.find(Condition.text(name)).$$("td:nth-child(4) input").first().click();
    }

    @Step
    @When("I click on dropdown in column Type for user \"(.+)\"")
    public void clickOnDropDown(String name) {
        rows.find(Condition.text(name)).$$("td:nth-child(2) select").first().click();
    }

    //checks
    @Step
    @And("(\\d+) (NumberType Dropdowns|User names|Description images|Description texts under images|checkboxes) are displayed on Users Table on User Table Page")
    public void checkElementsAreDisplayed(int expQty, String elementType) {
        ElementsCollection elements;
        switch (elementType) {
            case "NumberType Dropdowns":
                elements = typeColumn;
                break;
            case "User names":
                elements = nameColumn;
                break;
            case "Description images":
                elements = imageColumn;
                break;
            case "Description texts under images":
                elements = descriptionColumn;
                break;
            case "checkboxes":
                elements = checkboxesColumn;
                break;
            default:
                throw new RuntimeException("Unexpected element type");
        }
        elements.shouldHaveSize(expQty);
        for (SelenideElement element : elements) {
            element.shouldBe(Condition.visible);
        }
    }

    @Step
    @And("User table contains following values:")
    public void checkUserTableValues(@Transpose DataTable arg) {
        List<List<String>> table = arg.cells();
        numberColumn.shouldHave(texts(table.get(0).subList(1, arg.width())));
        nameColumn.shouldHave(texts(table.get(1).subList(1, arg.width())));
        descriptionColumn.shouldHave(texts(table.get(2).subList(1, arg.width())));
    }

    @Step
    @Then("droplist contains values:")
    public void checkDroplistOptions(List<String> expOptions) {
        ElementsCollection dropdownOptions = typeColumn.find(Condition.focused).$$("option");
        dropdownOptions.shouldHave(texts(expOptions.subList(1, expOptions.size())));
    }

    @Step
    @Then("(\\d+) log row has \"(.+)\" text in log section")
    public void checkLogRowText(int qty, String logText) {
        rightSection.checkLogRowText(qty, logText);
    }
}
