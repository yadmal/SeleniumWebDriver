package ru.selenium2.test.L31ParallelStart.consistentExecution;

import org.junit.Test;
import org.openqa.selenium.By;

public class MyThirtTest extends consistentExecution {

    @Test
    public void myFirstTest(){
        driver.navigate().to("http://google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver");
    }

    @Test
    public void mySecondTest(){
        driver.navigate().to("http://google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver");
    }

    @Test
    public void myThirtTest(){
        driver.navigate().to("http://google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver");
    }
}
