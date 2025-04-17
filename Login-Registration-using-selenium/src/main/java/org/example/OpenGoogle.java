package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenGoogle {
    public static void main(String[] args) {

//        System.setProperty("webdriver.chrome.driver","D:\\Downloads\\driver\\chromedriver-win64\\chromedriver.exe");
//        WebDriver driver =  new ChromeDriver();
//        driver.get("https://www.google.com/");

//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.google.com/");

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
    }
}