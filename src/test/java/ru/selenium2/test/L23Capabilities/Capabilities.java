package ru.selenium2.test.L23Capabilities;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Capabilities {
    private WebDriver driver;
    private WebDriverWait wait;

//    @Before
//    public void start(){
//
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // ожидает указанное время, если не получается найти элемент
//    }

    @Test
    public void searchElements(){
        DesiredCapabilities caps = new DesiredCapabilities(); // класс для представления настроек, будем передавать в конструктор драйвера
        caps.setCapability("unexpectedAlterBehaviour", "dismiss"); //установка параметров, которые передадим в конструктор драйвера
        driver = new ChromeDriver(caps);
        System.out.println(((HasCapabilities) driver).getCapabilities()); // для получения Capabilities в Java нужно сначала привести ссылку на драйвер к HasCapabilities
        wait = new WebDriverWait(driver, 10);
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
