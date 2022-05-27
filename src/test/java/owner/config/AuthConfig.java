package owner.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "file:/tmp/secret.properties", //try to read, if not successful go to the following line
        "classpath:auth.properties"
})

public interface AuthConfig extends Config {

    @Key("username")
    String username();

    @Key("password")
    String password();
}
