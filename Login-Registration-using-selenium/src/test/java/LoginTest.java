import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver driver;
    @Test
    public void setup()
    {
        driver = new ChromeDriver();
        driver.get("https://www.google.lk/");
        driver.findElement(By.name("q")).sendKeys("daraz.lk" + Keys.ENTER);
    }
}

