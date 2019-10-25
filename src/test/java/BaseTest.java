import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private static final Logger LOG = Logger.getLogger(BaseTest.class);

    private WebDriver driver;
    private static final String SITE_URL = "http://localhost/litecart/";

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    @BeforeMethod
    public void setUp()  {

        LOG.info("Initialization Chrome driver");

        WebDriverManager.chromedriver().version("77.0").setup();
        setDriver(new ChromeDriver());
        //driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        LOG.info("Navigation to " + SITE_URL);
        driver.navigate().to(SITE_URL);

    }

    @AfterMethod
    public void afterTest() {
        driver.close();
    }

}
