package pageObjects.JDIsite.sections;

import com.epam.jdi.uitests.web.selenium.elements.complex.TextList;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import org.openqa.selenium.support.FindBy;

public class ResultSection extends Section {

    @FindBy(css = ".results li")
    public TextList results;
}
