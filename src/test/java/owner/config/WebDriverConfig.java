package owner.config;

import java.util.Objects;

public class WebDriverConfig {

    public String getBaseUrl() {
        return "https://github.com";
    }

    public Browser getBrowser() {
        String browser = System.getProperty("browser");
        System.out.println(browser);
        if (Objects.isNull(browser)) {
            browser = "CHROME";
        }
        return Browser.valueOf(browser);
        //return Browser.FIREFOX;
    }


}
