package pageObjects.hw6;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import enums.ServiceOptions;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import pageObjects.hw6.commonElements.Header;
import pageObjects.hw6.commonElements.LeftSection;

import java.util.List;

import static com.codeborne.selenide.Selenide.page;

public class HomePage {

    @FindBy(css = "span.icons-benefit")
    private ElementsCollection images;

    @FindBy(css = "div.benefit-icon+span")
    private ElementsCollection textUnderImages;

    @FindBy(css = ".main-title")
    private SelenideElement mainTitle;

    @FindBy(css = ".main-txt")
    private SelenideElement mainTxt;

    private Header header;
    private LeftSection leftSection;

    public HomePage() {
        page(this);
        header = page(Header.class);
        leftSection = page(LeftSection.class);
    }

    //methods
    @Step
    @When("I am on \"Home Page\"")
    public void openPage() {
        Selenide.open("https://epam.github.io/JDI/");
    }

    @Step
    @When("I login as user \"(.+)\"")
    public void login(String name) {
        header.login(name);
    }

    @Step
    @When("I click on \"Service\" button in Header")
    public void chooseHeaderServiceCategory() {
        header.chooseHeaderServiceCategory();
    }

    @Step
    @When("I click on \"Service\" subcategory in the left section")
    public void chooseLeftServiceCategory() {
        leftSection.chooseServiceCategory();
    }

    @Step
    @And("I click on \"(.+)\" button in Service dropdown")
    public void chooseServiceOption(String optionName) {
        ServiceOptions option = ServiceOptions.getByName(optionName);
        header.chooseServiceOption(option);
    }

    public void chooseServiceDatesOption() {
        header.chooseServiceDatesOption();
    }

    //checks
    @Step
    @Then("Displayed user name is \"(.+)\"")
    public void checkUserIsLogged(String name) {
        header.checkUserIsLogged(name);
    }

    @Step
    @Then("dropdown in the header contains options:")
    public void checkHeaderServiceOptions(List<String> options) {
        header.checkServiceOptions(options);
    }

    @Step
    @Then("dropdown in the left section contains options:")
    public void checkLeftServiceOptions(List<String> options) {
        leftSection.checkServiceOptions(options);
    }

    @Step
    @And("(\\d+) (pictures|texts under pictures) exist")
    public void checkImages(int expQty, String elementName) {
        ElementsCollection elements;
        switch (elementName) {
            case "pictures":
                elements = images;
                break;
            case "texts under pictures":
                elements = textUnderImages;
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
    @And("2 texts above exist")
    public void checkTextsAboveIcons() {
        mainTitle.shouldBe(Condition.visible);
        mainTxt.shouldBe(Condition.visible);
    }
}
