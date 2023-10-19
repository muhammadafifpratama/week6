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

public class login {
    WebDriver driver;
    String baseurl = "https://www.saucedemo.com/";

    @Given("halaman login")
    public void halamanLogin() {
        driver = new ChromeDriver();
        driver.get(baseurl);
//        String title = driver.getTitle();
//        System.out.println(title);
    }

    @When("input username")
    public void inputUsername() {
        WebElement uname = driver.findElement(By.id("user-name"));
        uname.sendKeys("standard_user");
    }

    @And("input password")
    public void inputPassword() {
        WebElement upass = driver.findElement(By.id("password"));
        upass.sendKeys("secret_sauce");
    }

    @And("click login button")
    public void clickLoginButton() {
        WebElement login = driver.findElement(By.id("login-button"));
        login.click();
    }

    @Then("user in on dashboard page")
    public void userInOnDashboardPage() {
        String title = driver.findElement(By.className("title")).getText();
        Assert.assertEquals(title,"Products");
        driver.close();
//        System.out.println(title);
    }

    @And("input invalid password")
    public void inputInvalidPassword() {
        WebElement upass = driver.findElement(By.id("password"));
        upass.sendKeys("asd");
    }

    @Then("user get error message")
    public void userGetErrorMessage() {
        String error = driver.findElement(By.xpath("//h3[text()='Epic sadface: Username and password do not match any user in this service']")).getText();
//        System.out.println(error);
        Assert.assertEquals(error,"Epic sadface: Username and password do not match any user in this service");
        driver.close();
    }

    @When("input username locked")
    public void inputUsernameLocked() {
        WebElement uname = driver.findElement(By.id("user-name"));
        uname.sendKeys("locked_out_user");
    }

    @Then("user get error message locked")
    public void userGetErrorMessageLocked() {
        String error = driver.findElement(By.xpath("//h3[text()='Epic sadface: Sorry, this user has been locked out.']")).getText();
//        System.out.println(error);
        Assert.assertEquals(error,"Epic sadface: Sorry, this user has been locked out.");
        driver.close();
    }
}
