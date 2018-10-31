package pageObjects.hw4;

import com.codeborne.selenide.Selenide;
import enums.Users;
import pageObjects.hw4.base.Header;
import pageObjects.hw4.base.LeftSection;

public class HomePage extends AbstractPage {

    private Header header;
    private LeftSection leftSection;

    public HomePage() {
        header = Selenide.page(Header.class);
        leftSection = Selenide.page(LeftSection.class);
    }

    //methods
    public void openPage() {
        Selenide.open("https://epam.github.io/JDI/");
    }

    public void login(Users user) {
        header.login(user);
    }

    public void chooseHeaderServiceCategory() {
        header.chooseServiceCategory();
    }

    public void chooseLeftServiceCategory() {
        leftSection.chooseServiceCategory();
    }

    public void chooseServiceDifferentElementsOption() {
        header.chooseServiceDifferentElementsOption();
    }

    public void chooseServiceDatesOption() {
        header.chooseServiceDatesOption();
    }

    //checks
    public void checkUserIsLogged(Users user) {
        header.checkUserIsLogged(user);
    }

    public void checkHeaderServiceOptions() {
        header.checkServiceOptions();
    }

    public void checkLeftServiceOptions() {
        leftSection.checkServiceOptions();
    }
}
