package cucumber.stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class inventory {

    WebDriver driver;
    String baseurl = "https://www.saucedemo.com/";

    @Given("user already logged in")
    public void userAlreadyLoggedIn() {
        driver = new ChromeDriver();
        driver.get(baseurl);
        WebElement uname = driver.findElement(By.id("user-name"));
        uname.sendKeys("standard_user");
        WebElement upass = driver.findElement(By.id("password"));
        upass.sendKeys("secret_sauce");
        WebElement login = driver.findElement(By.id("login-button"));
        login.click();
    }

    @When("user in inventory page")
    public void userInInventoryPage() {
        String title = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(title,"Products");
    }

    @Then("user click add to cart")
    public void userClickAddToCart() {
        driver.findElement(By.xpath("//button[@data-test='add-to-cart-sauce-labs-backpack']")).click();
        driver.close();
    }

    @Then("user click an item")
    public void userClickAnItem() {
        driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).click();
        driver.close();
    }


//    @And("user click remove")
//    public void userClickRemove() {
//        driver.findElement(By.xpath("//button[@data-test='remove-sauce-labs-backpack']")).click();
////        driver.close();
//    }
}
