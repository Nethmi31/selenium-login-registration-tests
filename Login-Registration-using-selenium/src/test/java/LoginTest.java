import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {

    WebDriver driver;
    @BeforeMethod
    public void setup() throws InterruptedException {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        Thread.sleep(3000);
    }


    //Check Positive LogIn test,Negative username test, Negative password test
    @Test
    public void CheckLoginfunctionality() throws InterruptedException {

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("student");
        Thread.sleep(1500);
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Password123");
        Thread.sleep(1500);
        WebElement submitbtn =  driver.findElement(By.id("submit"));
        submitbtn.click();

        String url = driver.getCurrentUrl();
        System.out.println(url);
        if(url.equals("https://practicetestautomation.com/logged-in-successfully/")){
            System.out.println("Loggin success");
        }


        WebElement divelement = driver.findElement(By.className("post-content"));
        String actualText = divelement.getText();
        String expectedText = "Congratulations student. You successfully logged in!";
        if(actualText.contains(expectedText)){
            System.out.println("Expected text exists");
        }else{
            System.out.println("Expected text not exists");
        }

        WebElement linked = driver.findElement(By.linkText("Log out"));
        linked.click();
        System.out.println("User successfully logged out from the figma");

        //Going To Check Negative path of the test case

        WebElement username1 = driver.findElement(By.id("username"));
        username1.sendKeys("incorrectUser ");
        Thread.sleep(1500);
        WebElement password1 = driver.findElement(By.id("password"));
        password1.sendKeys("Password123");
        Thread.sleep(1500);
        WebElement submitbtn1 =  driver.findElement(By.id("submit"));
        submitbtn1.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errormessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));

        String errormesagTxt = errormessage.getText();
        System.out.println(errormesagTxt);

        String expectederrormsg = "Your username is invalid!";

        if(errormesagTxt.contains(errormesagTxt)){
            System.out.println("Expected error message displayed- Test passed");
        }else{
            System.out.println("Expected error message not displayed- Test fails");
        }

        driver.navigate().refresh();

        //3rd Test case

        WebElement username2 = driver.findElement(By.id("username"));
        username2.sendKeys("student");
        Thread.sleep(1500);
        WebElement password2 = driver.findElement(By.id("password"));
        password2.sendKeys("incorrectPassword");
        Thread.sleep(1500);
        WebElement submitbtn2 =  driver.findElement(By.id("submit"));
        submitbtn2.click();

        WebDriverWait wait2 = new WebDriverWait(driver,Duration.ofSeconds(10));
        WebElement errormsg2 = wait2.until(ExpectedConditions.visibilityOfElementLocated(By.id("error")));

        String errormsg2text = errormsg2.getText();
        System.out.println(errormsg2text);

        String expectederrormsg2 = "Your password is invalid!";

        if(expectederrormsg2 .contains(errormsg2text)){
            System.out.println("Expected error message displayed- Test passed");
        }else{
            System.out.println("Expected error message not displayed- Test fails");
        }



    }

}

