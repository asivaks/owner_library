package owner.config;

import org.aeonbits.owner.Config;

import java.net.URL;

@Config.Sources({
        "classpath:credentials.properties", //try to read, if not successful go to the following line
//        "classpath:auth.properties"
})

public interface WebDriverConfig extends Config {

    //gets from system properties keys and transforms them into
    @Key("baseUrl")
    @DefaultValue("https://github.com")
    String baseUrl();

    @Key("browser")
    @DefaultValue("CHROME")
    String browser();

    @Key("browserVersion")
    @DefaultValue("")
    String browserVersion();

    @Key("useRemote")
    @DefaultValue("")
    String useRemote();

    @Key("remoteUser")
    @DefaultValue("")
    String remoteUser();

    @Key("remotePassword")
    @DefaultValue("")
    String remotePassword();

    @Key("remoteUrl")
    @DefaultValue("")
    String remoteUrl();
}
