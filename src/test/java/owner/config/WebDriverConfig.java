package owner.config;

public class WebDriverConfig {

    public Browser getBrowser() {
        String browser = System.getProperty("browser");
        return Browser.valueOf(browser);
        //return Browser.FIREFOX;
    }

    public String getBaseUrl() {
        return "https://github.com";
    }
}
