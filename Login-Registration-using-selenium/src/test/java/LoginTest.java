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
        driver.get("https://www.google.lk/");
        driver.findElement(By.name("q")).sendKeys("thilakawardhana.lk" + Keys.ENTER);

    }

    //Redirected to the dashboard page
    @Test
    public void MoveDashboard(){
        WebElement HomeLink = driver.findElement(By.xpath("/html/body/div[3]/div/div[11]/div/div[2]/div[2]/div/div/div[1]/div/div/div/div/div/div/div/div[1]/div[2]/div/div/span/a"));
        HomeLink.click();
    }
}

