package ui;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverWrapper {
    WebDriver driver;

    public DriverWrapper() {
        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\geckodriver.exe");
        driver = new FirefoxDriver();
        WebDriverRunner.setWebDriver(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void close() {
        driver.close();
    }

    public UiRequest setUp() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return new UiRequest(driver);
    }
}
