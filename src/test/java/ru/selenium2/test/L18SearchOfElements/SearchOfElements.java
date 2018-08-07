package ru.selenium2.test.L18SearchOfElements;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SearchOfElements {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // ожидает указанное время, если не получается найти элемент
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void searchElements(){
//        driver.get("http://www.google.com");
        driver.navigate().to("http://google.com");
        WebElement q = driver.findElement(By.name("q"));
        driver.navigate().refresh(); // после обновления страницы элемент q сменит свой id и дальнейшее обращение к нему в программе вызовет StaleElementReferenceException
        q.sendKeys("webDriver");
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
