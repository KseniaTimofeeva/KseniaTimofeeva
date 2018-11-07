package pageObjects.JDIsite;

import com.epam.jdi.uitests.web.selenium.elements.common.Label;
import com.epam.jdi.uitests.web.selenium.elements.composite.WebSite;
import com.epam.jdi.uitests.web.selenium.elements.pageobjects.annotations.JSite;
import dto.MetalsAndColorsData;
import dto.User;
import enums.HeaderMenuItem;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pageObjects.JDIsite.pages.HomePage;
import pageObjects.JDIsite.pages.MetalAndColorsPage;
import pageObjects.JDIsite.sections.Header;
import pageObjects.JDIsite.sections.LoginForm;
import pageObjects.JDIsite.sections.ResultSection;

@JSite("https://epam.github.io/JDI/")
public class JDISite extends WebSite {

    public static HomePage homePage;
    public static Header header;
    public static LoginForm loginForm;
    public static MetalAndColorsPage metalAndColorsPage;
    public static ResultSection resultSection;

    @FindBy(css = ".profile-photo")
    public static Label profilePhoto;

    //methods
    @Step
    public static void login(User user) {
        profilePhoto.click();
        loginForm.loginAs(user);
    }

    @Step
    public static void chooseHeaderMenu(HeaderMenuItem item) {
        header.headerMenu.select(item);
    }

    //checks
    @Step
    public static void checkResultSectionContainsData(MetalsAndColorsData expectedData) {
        Assert.assertEquals(resultSection.results.getTextList(), metalAndColorsPage.getExpectedResults(expectedData));
    }


}
