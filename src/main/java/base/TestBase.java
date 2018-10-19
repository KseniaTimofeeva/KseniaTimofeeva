package base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.setProperty;

/**
 * Created by ksenia on 15.10.2018.
 */
public class TestBase {

    private long time;
    public static final String token = "!@$#%$#@#@$@$#%$%#";

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        time = currentTimeMillis();
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        System.out.println("Test framework worked: " + (currentTimeMillis() - time));

    }
}
