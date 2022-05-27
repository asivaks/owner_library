package owner.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.function.Supplier;

public class WebDriverProvider implements Supplier<WebDriver> {

    //private WebDriverConfigLegacy config;
    private WebDriverConfig config;

    public WebDriverProvider() {
        //this.config = new WebDriverConfigLegacy();
        this.config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    }

    @Override
    public WebDriver get() {
        WebDriver driver = createWebDriver();
        driver.get(config.baseUrl());
        return driver;
    }

    private WebDriver createWebDriver() {
        if (config.browser().equals(Browser.CHROME)) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        }
        if (config.browser().equals(Browser.FIREFOX)) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }
        throw new RuntimeException("No such browser");
    }



}
