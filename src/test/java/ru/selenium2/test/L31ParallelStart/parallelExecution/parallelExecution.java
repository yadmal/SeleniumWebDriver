package ru.selenium2.test.L31ParallelStart.parallelExecution;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class parallelExecution {
    public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>(); // хранение экземпляров WebDriver
    public WebDriver driver; // больше не статический
    public WebDriverWait wait;

    @Before
    public void start(){
        if(tlDriver.get() != null){
            driver = tlDriver.get();
            wait = new WebDriverWait(driver, 10);
            return;
        }
        driver = new FirefoxDriver();
        tlDriver.set(driver);
        wait = new WebDriverWait(driver, 10);


        //Выход после выполнения всех тестов. Используется вместо @After, который выполнялся бы после каждого теста
        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> { driver.quit(); driver = null;}));
    }

}
