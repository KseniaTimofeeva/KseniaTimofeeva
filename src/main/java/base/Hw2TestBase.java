package base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static java.lang.System.setProperty;

/**
 * Created by ksenia on 20.10.2018.
 */
public class Hw2TestBase {

    @BeforeSuite()
    public void beforeSuite() {
        setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    }

    @AfterSuite()
    public void afterSuite() {
        System.out.println(System.currentTimeMillis());
    }
}
