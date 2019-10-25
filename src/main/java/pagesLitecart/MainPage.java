package pagesLitecart;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class MainPage {

    private static final Logger LOG = Logger.getLogger(MainPage.class);
    public WebDriver driver;

    @FindBy(xpath = "//li[@class='account dropdown']")
    private WebElement signIn;
    @FindBy(xpath = "//a[text()='New customers click here']") //a[contains(href, 'create_account']
    private WebElement createNewCustomerLink;
    @FindBy (xpath = "//a[contains(@href,'checkout')]")
    private WebElement checkoutShoppingCartLink;

    /*@FindBy(xpath = "//div[@class='change']")
    private WebElement change;*/

    //Table
    @FindBy(xpath = "//ul[contains(@class,'d nav-tabs')]//a")
    private List<WebElement> productTypeNavTab;
    @FindBy (xpath = "//div[@class='tab-content']")
    private WebElement productsTable;

    @FindBy (xpath = "//button[@name='add_cart_product']")
    private WebElement addToCartButton;
    @FindBy (xpath = "//div[contains(@class,'featherlight-close')]")
    private WebElement closeItemWindowIcon;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public MainPage openSignInForm() {
        signIn.click();
        return this;
    }

   /* public void clickChange() {
        change.click();
    } */

    public CreateAccountPage openCreateAccount(){
        createNewCustomerLink.click();
        return new CreateAccountPage(driver);
    }

    public String waitGetErrorMessage() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        String textMessage=webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div" +
                "[@class='alert alert-success']")))).getText();
        //System.out.println("textMessage =" + textMessage);
        String clearText=textMessage.split("[\n]")[1];
        //System.out.println("text =" + clearText);
        return clearText;
    }

    public MainPage selectProductType(String name) {
        LOG.info("Selecting product type....");
        for (WebElement productType : productTypeNavTab) {
            System.out.println("IN the menu product type");
            System.out.println(productType.getText());
            if (productType.getText().contains(name)) {
                productType.click();
                System.out.println("Click");
                break;
            }
        }
        return this;
    }

    public MainPage selectProductItem(String name) {
        LOG.info("Selecting product item....");
        List<WebElement> itemNames = productsTable.findElements(By.cssSelector(".product .name"));
        for (WebElement itemName : itemNames) {
            System.out.println("IN the list of product");
            System.out.println(itemName.getText());
            if (itemName.getText().contains(name)) {
                itemName.click();
                System.out.println("Click");
                break;
            }

        }
        return this;
    }

    public MainPage addToCart() {
        addToCartButton.click();
        System.out.println("Add to cart");
        return this;
    }

    public MainPage closeItemWindow(){
        closeItemWindowIcon.click();
        System.out.println("Close item window");
        return this;
    }
    public ShoppingCartPage openShoppingCartPage() throws InterruptedException {

        //WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        //webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='quantity']")));
        Thread.sleep(3000); // Какое ожидание подойдет???
        checkoutShoppingCartLink.click();
        System.out.println("Open Cart");
        return new ShoppingCartPage(driver);
    }


}
