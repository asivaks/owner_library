package owner.config;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class WebDriverConfigLegacy {

    public URL remoteBaseUrl() {
        String remoteUrl = System.getProperty("remoteUrl");
        if (Objects.isNull(remoteUrl)) {
            remoteUrl = "https://selenium:4444/wd/hub";
        }
        try {
            return new URL(remoteUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getBaseUrl() {
        String baseUrl = System.getProperty("baseUrl");
        if (Objects.isNull(baseUrl)) {
            baseUrl = "https://github.com";
        }
        return baseUrl;
    }

    public Browser getBrowser() {
        String browser = System.getProperty("browser");
        System.out.println("Browser set to " + browser);  //WHY IT IS NOT IN THE CONSOLE?
        if (Objects.isNull(browser)) {
            browser = "CHROME";
        }
        return Browser.valueOf(browser);
        //return Browser.FIREFOX;
    }


}
