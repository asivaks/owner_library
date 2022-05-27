package owner.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:api.properties", //try to read, if not successful go to the following line
//        "classpath:auth.properties"
})

public interface ApiConfig extends Config {

    @Key("baseUrl")
    String baseUrl();

    @Key("lat")
    String lat();

    @Key("lon")
    String lon();

    @Key("apiKey")
    String apiKey();
}
