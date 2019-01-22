package StepDefinitions;


import Pages.HomePage;
import Pages.MyAccountPage;
import Pages.signinPage;
import Utilities.Driver;
import Utilities.TestBase;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.collections.Maps;


import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class loginStepdefs extends TestBase {

HomePage homepage=new HomePage();
    signinPage signinPage=new signinPage();
    MyAccountPage myAccountPage=new MyAccountPage();
    @Given("user is on home page")
    public void user_is_on_home_page() {
        Driver.getDriver().get("http://automationpractice.com/index.php");
       //driver.get("http://automationpractice.com/index.php");
    }

    @When("user clicks on the Sign in button")
    public void user_clicks_on_the_Sign_in_button() {

        homepage.signin.click();//driver.findElement(By.linkText("Sign in")).click();
    }

    @When("user enters username and password")
    public void user_enters_username_and_password() {
       signinPage.email.sendKeys("oscar6161@gmail.com");
        signinPage.password.sendKeys("Password61");
    }

    @Then("user will click Sign in button again")
    public void user_will_click_Sign_in_button_again()
    {
      signinPage.signInButton.click();//  driver.findElement(By.id("SubmitLogin")).click();
    }
    String accountName;
    @Then("user confirms that fullname is shown by SignOutlink")
    public void user_confirms_that_fullname_is_shown_by_SignOutlink() {
        accountName=myAccountPage.fullname.getText();
        Assert.assertEquals(accountName,"Oscar Bono");


    }
   String fullname;
    @Then("use clicks on My Personal Info and verify first and last name is correct")
    public void use_clicks_on_My_Personal_Info_and_verify_first_and_last_name_is_correct() throws InterruptedException {
        myAccountPage.personalInformation.click();//driver.findElement(By.xpath("//a[.='My personal information']")).click();
        Thread.sleep(3000);
        fullname= myAccountPage.firstNameAddress.getAttribute("value")+" "+myAccountPage.lastNameAddress.getAttribute("value");
        Assert.assertEquals(accountName,fullname);
    }

    @Then("user clicks save button")
    public void user_clicks_save_button() {
       // myAccountPage.backtoAccount.click();
        myAccountPage.save.click();
        //driver.findElement(By.xpath("//span[.='Save']")).click();
    }


    String message;
    @Then("user confirms the error message saying The password you entered is incorrect")
    public void user_confirms_the_error_message_saying_The_password_you_entered_is_incorrect() {
       message=myAccountPage.alertMessage.getText();
        Assert.assertEquals(message,"The password you entered is incorrect.");
    }

    @Then("user clicks on Back to your account and verify title contains My account")
    public void user_clicks_on_Back_to_your_account_and_verify_title_contains_My_account() {
        myAccountPage.backtoAccount.click();
        String title=Driver.getDriver().getTitle();
        Assert.assertTrue(title.contains("My account"));
    }
    @Then("Clickon My addresses")
    public void clickon_My_addresses() {
        myAccountPage.myAddresses.click();
        //driver.findElement(By.xpath("//a[.='My addresses']")).click();

    }

    @Then("Clickon Add a new address")
    public void clickon_Add_a_new_address() {

        driver.findElement(By.xpath("//a[.='Add a new address']")).click();
    }

    @And("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
    public void userEntersAnd(String username, String password) throws Throwable {
        signinPage.email.sendKeys(username);
        signinPage.password.sendKeys(password);
    }

    @Then("confirms address details")
    public void confirms_address_details(Map<String,String> addressDetails) {
        System.out.println( addressDetails.get("name"));
        System.out.println( addressDetails.get("phone"));
        System.out.println( addressDetails.get("city"));
    }
   /* @Then("Verify that first name and last name matches the full name on top")
    public void verify_that_first_name_and_last_name_matches_the_full_name_on_top() {
        Assert.assertEquals(userName,fullname);
    }

    @Then("Delete the first name and Click save")
    public void delete_the_first_name_and_Click_save() {
        driver.findElement(By.id("firstname")).clear();

        driver.findElement(By.id("submitAddress")).click();
    }

    @Then("Verify error message firstname is required.")
    public void verify_error_message_firstname_is_required() {
        message=driver.findElement(By.xpath("//div[@class='alert alert-danger']//li[1]")).getText();
        Assert.assertEquals(message,"firstname is required.");
    }*/
}
