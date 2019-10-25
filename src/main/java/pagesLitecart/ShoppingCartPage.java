package pagesLitecart;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShoppingCartPage {

    private static final Logger LOG = Logger.getLogger(MainPage.class);
    public WebDriver driver;

    @FindBy (xpath = "//strong//a[contains(@href,'purple-duck')]")
    private WebElement itemName;
    @FindBy (xpath = "//div[@id='box-checkout-cart']//tbody")
    private WebElement cartBody;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String CheckItemNameInCart(String name) {
        LOG.info("Searching for product name (Cart)....");
        List<WebElement> itemNames = cartBody.findElements(By.xpath("//div[@id='box-checkout-cart']//tbody//tr[@data-name]"));
        String item = "item not in the cart";
        for (WebElement itemName : itemNames) {
            System.out.println("IN the list of product");
            System.out.println(itemName.getAttribute("data-name"));
            if (itemName.getAttribute("data-name").contains(name)) {
                item = name;
            }
        }
        return item;
    }
    public String getItemNameFromCart() {
        return  itemName.getText();
    }

    public String CheckItemNameInCartJava8(final String name) {
        LOG.info("Searching for product name (Cart)....");
        List<WebElement> itemNames = cartBody.findElements(By.xpath("//div[@id='box-checkout-cart']//tbody//tr[@data-name]"));
        String item = "item not in the cart";
        WebElement nameItem;
        nameItem = itemNames.stream().filter(nItem -> nItem.getAttribute("data-name").contains(name)).
                findFirst().
                get();

        item = nameItem.getAttribute("data-name");


        return item;
    }

}
