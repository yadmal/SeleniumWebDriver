package ru.selenium2.test.L24BrowserOptions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserOptions {

    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-fullscreen"); // аргументы представляют собой опции командной строки, которые будут использованы при запуске браузера
        driver = new ChromeDriver(options);
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setCapability(ChromeOptions.CAPABILITY, options); //упаковываем опции командной строки внутрь объекта Capabilities
//        driver = new ChromeDriver(caps);
        wait = new WebDriverWait(driver, 10);

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
        caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        driver = new InternetExplorerDriver(caps);


    }

    @Test
    public void browserOption(){
        driver.navigate().to("http://google.com");
        driver.findElement(By.name("q")).sendKeys("webdriver");
    }

    @After
    public void stop(){
        driver.quit();
        driver = null;
    }
}
