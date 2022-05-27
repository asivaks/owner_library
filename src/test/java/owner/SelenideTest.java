package owner;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;
import owner.config.WebDriverConfig;
import com.codeborne.selenide.Configuration;


import static com.codeborne.selenide.Selenide.*;
import static org.assertj.core.api.Assertions.assertThat;


public class SelenideTest {

    @Test
    void gitHubTest() {
    WebDriverConfig config = ConfigFactory.create(WebDriverConfig.class);
    Configuration.baseUrl = config.baseUrl();
    Configuration.browserSize = "1920x1080";
    Configuration.browser = config.browser();
    Configuration.browserVersion = config.browserVersion();
    System.out.println(config.useRemote());
    if (config.useRemote().compareTo("true") == 0) {
        String remoteString = "https://" + config.remoteUser() + ":" + config.remotePassword() + "@" + config.remoteUrl();
        Configuration.remote = remoteString;
    }
        open("");
        assertThat(title()).isEqualTo("GitHub: Where the world builds software · GitHub");

    }
}
