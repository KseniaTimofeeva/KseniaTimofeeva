package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;

public class HomePage {

    @FindBy(css = ".profile-photo")
    private WebElement profileButton;

    @FindBy(css = "[id = 'Name']")
    private WebElement login;

    @FindBy(css = "[id = 'Password']")
    private WebElement password;

    @FindBy(css = ".login [type = 'submit']")
    private WebElement submit;

    @FindBy(css = "")
    private WebElement mainText;

    //methods
    public void open(WebDriver driver) {
        driver.get("");
    }

    public void login(String name, String passwd) {
        profileButton.click();
        login.sendKeys(name);
        password.sendKeys(passwd);
        submit.click();

    }

    //checks
    public void checkTitle(WebDriver driver) {
        assertEquals(driver.getTitle(), "");
    }

    public void checkMainText() {
        assertEquals(mainText.getText(), "");
    }

}
