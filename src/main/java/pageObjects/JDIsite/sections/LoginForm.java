package pageObjects.JDIsite.sections;

import com.epam.jdi.uitests.web.selenium.elements.common.Button;
import com.epam.jdi.uitests.web.selenium.elements.common.TextField;
import com.epam.jdi.uitests.web.selenium.elements.composite.Form;
import dto.User;
import org.openqa.selenium.support.FindBy;

public class LoginForm extends Form<User> {
    @FindBy(css = "[id = 'Name']")
    public TextField name;

    @FindBy(css = "[id = 'Password']")
    public TextField password;

    @FindBy(css = ".login [type = 'submit']")
    public Button enter;

}
