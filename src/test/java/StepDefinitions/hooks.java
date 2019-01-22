package StepDefinitions;

import Utilities.Driver;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class hooks {


    @Before
    public void setUp()
    {
       //driver= Driver.getDriver();
        //driver.get("http://automationpractice.com/index.php");
        Driver.getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();

    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        Driver.closeDriver();
    }
}
