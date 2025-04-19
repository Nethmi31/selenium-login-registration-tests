import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class OpenGoogleTest {
    WebDriver driver;
    @BeforeMethod
    public void googleTest(){
        driver=new ChromeDriver();
        driver.get("https://www.leafground.com/link.xhtml");
        driver.manage().window().maximize();
    }

    @Test
    public void LinkTest(){
        WebElement homelink = driver.findElement(By.linkText("Go to Dashboard"));
        homelink.click();
        driver.navigate().back();

        WebElement destination = driver.findElement(By.partialLinkText("Find the URL"));
        String path = destination.getAttribute("href");
        System.out.println("This link is going to: "+ path);

        //broken link
        WebElement brokenlink = driver.findElement(By.linkText("Broken?"));
        brokenlink.click();
        String title = driver.getTitle();
        if(title.contains("404")){
            System.out.println("The link is broken");
        }else{
            System.out.println("Not broken");
        }
        driver.navigate().back();

        //duplicate link
        WebElement homelink1 = driver.findElement(By.linkText("Go to Dashboard"));
        homelink1.click();
        driver.navigate().back();

        //Countlink
        List<WebElement> Countelement= driver.findElements(By.tagName("a"));
        int pagelinkCount= Countelement.size();
        System.out.println("Count of links in full page: "+pagelinkCount);

        //CountLayoutLink
        WebElement layoutelement = driver.findElement(By.className("layout-main-content"));
        List<WebElement> countoflayoutlink=layoutelement.findElements(By.tagName("a"));
        System.out.println("Count of layout links: "+countoflayoutlink.size());

    }
}
