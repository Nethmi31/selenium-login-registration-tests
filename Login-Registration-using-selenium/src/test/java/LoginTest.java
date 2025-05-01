import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    public void CheckLoginfunctionality(){

        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("student");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Password123");
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


    }
}

