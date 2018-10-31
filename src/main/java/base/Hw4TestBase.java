package base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

import static java.lang.System.setProperty;

public class Hw4TestBase {

    @BeforeSuite
    public void beforeSuite() {
        setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        Configuration.startMaximized = true;
        Configuration.browser = "chrome";
    }
}
