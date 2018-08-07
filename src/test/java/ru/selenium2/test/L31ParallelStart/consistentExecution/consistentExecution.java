package ru.selenium2.test.L31ParallelStart.consistentExecution;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class consistentExecution {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @Before
    public void start(){
        if(driver != null){
            return;
        }
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);

        //Выход после выполнения всех тестов. Используется вместо @After, который выполнялся бы после каждого теста
        Runtime.getRuntime().addShutdownHook(
                new Thread(() -> { driver.quit(); driver = null;}));
    }

}
