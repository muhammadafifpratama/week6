package cucumber.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class cart {

    WebDriver driver;
    String baseurl = "https://www.saucedemo.com/";

    @Given("user in cart page")
    public void userInCartPage() {
        driver = new ChromeDriver();
        driver.get(baseurl);
        WebElement uname = driver.findElement(By.id("user-name"));
        uname.sendKeys("standard_user");
        WebElement upass = driver.findElement(By.id("password"));
        upass.sendKeys("secret_sauce");
        WebElement login = driver.findElement(By.id("login-button"));
        login.click();
    }

    @And("user already have items in cart")
    public void userAlreadyHaveItemsInCart() {
        driver.findElement(By.xpath("//button[@data-test='add-to-cart-sauce-labs-backpack']")).click();
        driver.findElement(By.className("shopping_cart_link")).click();
    }

    @When("user checkout")
    public void userCheckout() {
        driver.findElement(By.id("checkout")).click();
    }

    @Then("input Firstname")
    public void inputFirstname() {
        driver.findElement(By.xpath("//input[@data-test='firstName']")).sendKeys("firstname");
    }

    @And("input Lastname")
    public void inputLastname() {
        driver.findElement(By.xpath("//input[@data-test='lastName']")).sendKeys("secondname");
    }

    @And("input Postal code")
    public void inputPostalCode() {
        driver.findElement(By.xpath("//input[@data-test='postalCode']")).sendKeys("12345");
    }

    @Then("click continue")
    public void clickContinue() {
        driver.findElement(By.xpath("//input[@data-test='continue']")).click();
    }

    @Then("click finish")
    public void clickFinish() {
        driver.findElement(By.xpath("//button[@data-test='finish']")).click();
        driver.close();
    }
}
