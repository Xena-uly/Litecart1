import model.Account;
import org.testng.Assert;
import org.testng.annotations.Test;
import pagesLitecart.MainPage;

public class CreateAccountTests extends BaseTest {

    @Test
    public void verifyCreateAccount() throws InterruptedException {
        Account index = new Account();
        Account accountDetales = new Account.AccountBuilder().
                firstName("FirstName").
                lastName("LastName").
                country("Ukraine").
                email("mail" + index.changeMailIndex() + "@in.ua").
               // email("mail@in.ua").
                desiredPassword("123456").
                confirmPassword("123456").
                createAccount();

        MainPage mainPage = new MainPage(getDriver());
                mainPage.openSignInForm().
                openCreateAccount().
                        fillCreateAccountForm(accountDetales).
                        clickCreateAccountButton();

                String actualResult = mainPage.waitGetErrorMessage();
                //System.out.println("Actual result is -" + actualResult);
                Assert.assertEquals( actualResult,"Your customer account has been created.", "Account is not created");

    }

}
