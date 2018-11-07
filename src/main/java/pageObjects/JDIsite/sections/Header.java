package pageObjects.JDIsite.sections;

import com.epam.jdi.uitests.web.selenium.elements.complex.Menu;
import com.epam.jdi.uitests.web.selenium.elements.composite.Section;
import enums.HeaderMenuItem;
import org.openqa.selenium.support.FindBy;

public class Header extends Section {

    @FindBy(css = ".uui-navigation.m-l8")
    public Menu<HeaderMenuItem> headerMenu;

}
