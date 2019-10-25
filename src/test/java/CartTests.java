import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesLitecart.MainPage;
import pagesLitecart.ShoppingCartPage;

public class CartTests extends BaseTest {

    @Test
    public void verifyAddToCart() throws InterruptedException {

        MainPage mainPage = new MainPage(getDriver());
        mainPage.selectProductType("Latest Product")
                .selectProductItem("Purple Duck")
                .addToCart()
                .closeItemWindow()
                .openShoppingCartPage();

        ShoppingCartPage shoppingCart = new ShoppingCartPage(getDriver());
        String actualResult = shoppingCart.CheckItemNameInCartJava8("Purple Duck");
        //String actualResult = shoppingCart.CheckItemNameInCart("Purple Duck");
        //String actualResult = shoppingCart.getItemNameFromCart();
        Assert.assertEquals( actualResult,"Purple Duck", "Item is not added to cart");

    }




}
