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
    public void setup()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://thilakawardhana.com/");
    }

    //Redirected to the user icon
    @Test
    public void findusericon(){
        WebElement account = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/sticky-header[1]/header[1]/div[1]/div[2]/div[1]/a[1]/*[name()='svg'][1]"));
        account.click();
    }

    //Happy path for the login.
    public void happypath(){
        WebElement email=driver.findElement(By.id("customer_email"));
        email.sendKeys("h.u.g.nethmirashmika@gmail.com");
    }

}

