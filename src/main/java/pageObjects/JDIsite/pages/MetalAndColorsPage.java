package pageObjects.JDIsite.pages;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JPage;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.objects.JDropdown;
import dto.MetalsAndColorsData;
import enums.Color;
import enums.Element;
import enums.Even;
import enums.Metal;
import enums.Odd;
import enums.Vegetable;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@JPage(url = "/metals-colors.html", title = "Metal and Colors")
public class MetalAndColorsPage extends WebPage {

    @FindBy(css = "#odds-selector p")
    public RadioButtons<Odd> oddsSummary;

    @FindBy(css = "#even-selector p")
    public RadioButtons<Even> evensSummary;

    @FindBy(css = "#elements-checklist p")
    private CheckList<Element> elements;

    @FindBy(css = "#submit-button")
    private Button submit;

    @JDropdown(
            root = @FindBy(id = "colors"),
            list = @FindBy(tagName = "li"),
            value = @FindBy(tagName = "button")
    )
    private Dropdown<Color> colors;

    @JDropdown(
            root = @FindBy(id = "metals"),
            list = @FindBy(tagName = "li"),
            expand = @FindBy(css = ".caret")
    )
    private Dropdown<Metal> metals;

    @JDropdown(
            root = @FindBy(id = "salad-dropdown"),
            list = @FindBy(tagName = "li"),
            value = @FindBy(css = "button")
    )
    private Dropdown<Vegetable> vegetables;


    //methods
    @Step
    public void fillMetalsColorsForm(MetalsAndColorsData data) {
        oddsSummary.select(Odd.getByValue(data.summary.get(0)));
        evensSummary.select(Even.getByValue(data.summary.get(1)));

        elements.select(data.elements.toArray(new Element[data.elements.size()]));
        colors.select(data.color);
        metals.select(data.metals);

        vegetables.select(Vegetable.VEGETABLES);
        for (Vegetable vegetable : data.vegetables) {
            vegetables.select(vegetable);
        }
    }

    @Step
    public void submit() {
        submit.click();
    }

    // TODO Basically, this method has no relation with PO ...
    public List<String> getExpectedResults(MetalsAndColorsData data) {
        List<String> results = new ArrayList<>();
        results.add("Summary: " + String.valueOf(data.summary.get(0) + data.summary.get(1)));
        results.add("Elements: " + data.elements.stream().map(Element::getDisplayName).collect(Collectors.joining(", ")));
        results.add("Color: " + data.color.getDisplayName());
        results.add("Metal: " + data.metals.getDisplayName());
        results.add("Vegetables: " + data.vegetables.stream().map(Vegetable::getDisplayName).collect(Collectors.joining(", ")));
        return results;
    }
}
