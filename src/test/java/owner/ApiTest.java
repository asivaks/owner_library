package owner;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import owner.config.ApiConfig;
import owner.config.AuthConfig;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

@Tag("apiTest")
public class ApiTest {

    @Test
    public void sampleTest() throws IOException, InterruptedException {
        final String POST_API_URL = "https://jsonplaceholder.typicode.com/posts";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(POST_API_URL))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        //System.out.println(response.body());
        System.out.println(response.statusCode());

        assertThat(response.statusCode()).isEqualTo(200);
    }

    @Test
    public void weatherTest() throws IOException, InterruptedException {

        //final String urlStringSample = "https://samples.openweathermap.org/data/2.5/weather?lat=35&lon=139&appid=b1b15e88fa797225412429c1c50c122a1";
        //String baseUrl = "https://samples.openweathermap.org";
        String pathUrl = "/data/2.5/weather";
        //int lat = 35;
        //int lon = 139;
        //String apiKey = "b1b15e88fa797225412429c1c50c122a1";

        ApiConfig config = ConfigFactory.create(ApiConfig.class, System.getProperties());

        String baseUrl = config.baseUrl();
        String lat = config.lat();
        String lon = config.lon();
        String apiKey = config.apiKey();

        String urlString = baseUrl + pathUrl + "?lat=" + lat + "&lon=" + lon + "&appid=" + apiKey;

        System.out.println("baseUrl= " + baseUrl);
        System.out.println("lat= " + lat);
        System.out.println("lon= " + lon);
        System.out.println("apiKey= " + apiKey);

        //assertThat(urlString).isEqualTo(urlStringSample);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(urlString))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("response.body()= " + response.body());
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(response.body(), JsonObject.class);
        assertFalse(jsonObject.get("coord").getAsJsonObject().get("lat").isJsonNull(), "lat is null");
        assertFalse(jsonObject.get("coord").getAsJsonObject().get("lon").isJsonNull(), "lon is null");

    }
}
