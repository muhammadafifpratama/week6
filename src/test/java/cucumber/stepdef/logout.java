package cucumber.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class logout {

    WebDriver driver;
    String baseurl = "https://www.saucedemo.com/";

    @Given("user login")
    public void userLogin() {
        driver = new ChromeDriver();
        driver.get(baseurl);
        WebElement uname = driver.findElement(By.id("user-name"));
        uname.sendKeys("standard_user");
        WebElement upass = driver.findElement(By.id("password"));
        upass.sendKeys("secret_sauce");
        WebElement login = driver.findElement(By.id("login-button"));
        login.click();
    }

    @When("user click logout button")
    public void userClickLogoutButton() {
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
////        driver.findElement(By.linkText("Logout")).click();
//        driver.findElement(By.id("logout_sidebar_link")).click();
        WebElement revealed = driver.findElement(By.id("logout_sidebar_link"));
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        wait.until(d -> revealed.isDisplayed());
        driver.findElement(By.id("logout_sidebar_link")).click();
        driver.close();
    }

    @When("user click menu")
    public void userClickMenu() {
        driver.findElement(By.id("react-burger-menu-btn")).click();
    }
}
