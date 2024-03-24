package test.httpcats;

import io.restassured.response.Response;
import org.example.utils.rest.client.HttpCatsClient;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HttpCatsTest {

    @DataProvider(name = "statuses-provider")
    public Object[][] provideStatuses() {
        return new Object[][]{{"101"}, {"103"}, {"200"}, {"201"},
                {"205"}, {"304"}, {"305"}, {"400"}, {"402"}, {"417"}, {"418"}, {"500"}, {"530"}
        };
    }

    @Test(description = "Проверяем разные коды", dataProvider = "statuses-provider")
    public void shouldReturnStatusCodeData(String status) throws IOException, URISyntaxException {
        Response response = new HttpCatsClient().getCat(status);
        response.then().statusCode(200);
    }

    @Test(description = "Проверяем картинки разных кодов", dataProvider = "statuses-provider")
    public void shouldReturnStatusCodeImages(String status) throws IOException, URISyntaxException {
        Path outputImageFile = Paths.get("src/test/java/resources/", "httpcats/", String.format("%s.jpg", status));
        Files.write(outputImageFile, new HttpCatsClient().getCat(status).asByteArray());
    }
}
