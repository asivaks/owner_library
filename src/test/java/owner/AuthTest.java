package owner;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import owner.config.AuthConfig;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

public class AuthTest {

    @Test
    public void testClasspath() {
        AuthConfig config = ConfigFactory.create(AuthConfig.class, System.getProperties());

        assertThat(config.username()).isEqualTo("testuser");
        assertThat(config.password()).isEqualTo("testpwd");
    }

    @Test
    public void testLocalFile() throws IOException {
        String content = "username=secrettestuser\npassword=secrettestpwd";
        Path propsPath = Paths.get("/tmp/secret.properties");
        Files.write(propsPath, content.getBytes(StandardCharsets.UTF_8));

        AuthConfig config = ConfigFactory.create(AuthConfig.class, System.getProperties());

        assertThat(config.username()).isEqualTo("secrettestuser");
        assertThat(config.password()).isEqualTo("secrettestpwd");

        Files.delete(propsPath);

    }
}
