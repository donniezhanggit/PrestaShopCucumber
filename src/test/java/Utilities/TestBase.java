package Utilities;
import Utilities.Driver;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


import java.util.Random;
import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    public WebDriver driver;

    protected Actions action;
    public String url="http://automationpractice.com/index.php";
    public Select select;
    public Faker faker;
    public Random rndm;


    @BeforeMethod
    public void setUp()
    {
        faker=new Faker();
      driver= Driver.getDriver();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        action= new Actions(driver);
        rndm=new Random();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        Driver.closeDriver();
        //softAssert.assertAll();
    }

}
