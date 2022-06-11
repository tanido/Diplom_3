import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.*;

import org.openqa.selenium.chrome.ChromeDriver;
import stellaburgers.pageobject.MainPage;


public class BaseTest {
    static ChromeDriver driver;

    @Before
    public void setUp(){
        //System.setProperty("webdriver.chrome.driver", "C:\\Webdriver\\yandexdriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Webdriver\\chromedriver.exe");
        driver = new ChromeDriver();
        WebDriverRunner.setWebDriver(driver);
        Selenide.open(MainPage.pageUrl);
        WebDriverRunner.getWebDriver().manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}