package Pages;

import Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id="header_logo")
    public WebElement logo;

    @FindBy(id="search_query_top")
    public WebElement search;

    @FindBy(className="login")
    public WebElement signin;

    @FindBy(className="logout")
    public WebElement logOut;

    @FindBy(xpath = "//*[@title='View my shopping cart']")
    public WebElement showCart;

    @FindBy(xpath = "//dl[@class='products']//dt//img")
    public WebElement itemOnCart;

    @FindBy(xpath = "//*[@class='ajax_cart_no_product']")
    public WebElement emptyCart;

    @FindBy(xpath = "//span[@class='remove_link']")
    public WebElement removeItem;
}
