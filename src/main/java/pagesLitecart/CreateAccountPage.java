package pagesLitecart;

import model.Account;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class CreateAccountPage {

    protected WebDriver driver;

    @FindBy(name = "firstname") //input[@name='firstname']
    private WebElement firstNameNewCustomer;
    @FindBy(name = "lastname") //input[@name='lastname']
    private WebElement lastNameNewCustomer;
    @FindBy(name = "country_code")//select[@name='country_code']
    private WebElement countryCode;
    @FindBy(xpath = "//select[@name='zone_code']")
    private WebElement zoneCode;
    @FindBy(xpath = "//div[@id='box-create-account']//input[@name='email']")
    private WebElement emailNewCustomer;
    @FindBy(xpath = "//div[@id='box-create-account']//input[@name='password']")
    private WebElement desiredPassword;
    @FindBy(xpath = "//div[@id='box-create-account']//input[@name='confirmed_password']")
    private WebElement confirmPassword;
    @FindBy (name = "create_account")
    private WebElement createAccountButton;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CreateAccountPage fillCreateAccountForm(Account account){

        typeNewCustomerFirstName(account.getFirstName());
        typeNewCustomerLastName(account.getLastName());
        selectCountry(account.getCountry());
        typeNewCustomerEmailAddress(account.getEmail());
        typeDesiredPasswordNewCustomer(account.getDesiredPassword());
        typeConfirmPasswordNewCustomer(account.getConfirmPassword());

        return this;
    }

    public void typeNewCustomerFirstName(String name) {
        firstNameNewCustomer.sendKeys(name);
    }

    public void typeNewCustomerLastName(String name) {
        lastNameNewCustomer.sendKeys(name);
    }

    public void typeNewCustomerEmailAddress(String email) {
        emailNewCustomer.sendKeys(email);
    }

    public void typeDesiredPasswordNewCustomer(String password) {
        desiredPassword.sendKeys(password);
    }

    public void typeConfirmPasswordNewCustomer(String password) {
        confirmPassword.sendKeys(password);
    }

    public void selectCountry(String country){

        Select selectCountry = new Select(countryCode);
        selectCountry.selectByVisibleText(country);
    }

    public void selectZone(String zoneName){

        Select selectZone = new Select(zoneCode);
        selectZone.selectByVisibleText(zoneName);
    }
    public void clickCreateAccountButton() throws InterruptedException {
        createAccountButton.click();
    }

}
