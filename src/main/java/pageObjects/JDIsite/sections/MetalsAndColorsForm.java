package pageObjects.JDIsite.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.complex.CheckList;
import com.epam.jdi.uitests.web.selenium.elements.complex.Dropdown;
import com.epam.jdi.uitests.web.selenium.elements.complex.RadioButtons;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
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

public class MetalsAndColorsForm extends Form<MetalsAndColorsData> {

    @FindBy(css = "#odds-selector p")
    public RadioButtons<Odd> oddsSummary;

    @FindBy(css = "#even-selector p")
    public RadioButtons<Even> evensSummary;

    @FindBy(css = "#elements-checklist p")
    private CheckList<Element> elements;

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

    @FindBy(css = "#submit-button")
    private Button submit;

    //methods
    @Override
    public void fill(MetalsAndColorsData entity) {
        oddsSummary.select(Odd.getByValue(entity.summary.get(0)));
        evensSummary.select(Even.getByValue(entity.summary.get(1)));

        elements.select(entity.elements.toArray(new Element[entity.elements.size()]));
        colors.select(entity.color);
        metals.select(entity.metals);

        vegetables.select(Vegetable.VEGETABLES);
        for (Vegetable vegetable : entity.vegetables) {
            vegetables.select(vegetable);
        }
    }

    @Step
    public void submit() {
        submit.click();
    }
}
