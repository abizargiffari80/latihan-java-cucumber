package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.LoginPage;

public class LoginSteps {

    public WebDriver driver;
    public LoginPage lp;

    @Given("Buka browser")
    public void buka_browser() {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        lp = new LoginPage(driver);
    }
    @When("User buka url {string}")
    public void user_buka_url(String url) {
        driver.manage().window().maximize();
        driver.get(url);
    }
    @When("User masukin email {string} dan password {string}")
    public void user_masukin_email_dan_password(String email, String password) {
        lp.setUserName(email);
        lp.setTxtPassword(password);
    }
    @When("Click login button")
    public void click_login_button() {
        lp.clickLogin();
    }
    @Then("Page tittle harusnya {string}")
    public void page_tittle_harusnya(String title) throws InterruptedException {
        if (driver.getPageSource().contains("Login was unsuccessful.")){
            //driver.quit();
            driver.close();
            Assert.assertTrue(false);
        } else {
            Assert.assertEquals(title, driver.getTitle());
        }
        Thread.sleep(3000);
    }
    @When("Click logout button")
    public void click_logout_button() {
        lp.clickLogout();
    }
    /*
    @Then("page tittle harusnya {string}")
    public void page_tittle_harusnya(String title) {
        Assert.assertEquals(title, driver.getTitle());
    }
    */
    @Then("close browser")
    public void close_browser() {
        //driver.quit();
        driver.close();
    }
}
