package ru.selenium2.test.L13ActionOnElements;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ActionsOnElements {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // ожидает указанное время, если не получается найти элемент
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void firstTest(){
//        driver.get("http://www.google.com");
        driver.navigate().to("http://google.com");
        driver.findElement(By.id("gs_ok0")).click(); // open screen board
        driver.findElement(By.id("K32")).click(); // press "space"
        driver.findElement(By.id("gs_ok0")).click(); // close screen board
        WebElement q = driver.findElement(By.name("q"));
        q.sendKeys("webDriver");
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
