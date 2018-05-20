package com.fsoft.base;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseWeb {
    public WebDriver driver;
    public void init()
    {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    public WebElement element (String xPath)
    {
        return driver.findElement(By.xpath(xPath));
    }

    public List<WebElement> elements (String xPath)
    {
        return driver.findElements(By.xpath(xPath));
    }
}