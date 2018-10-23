package base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

public class Hw4TestBase {

    @BeforeSuite
    public void beforeSuite() {
        Configuration.browser = "chrome";
    }
}
