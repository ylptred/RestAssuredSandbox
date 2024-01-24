package test.httpcats;

import io.restassured.RestAssured;
import org.example.utils.http.HttpAttributes;
import org.example.utils.http.HttpClient;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.example.utils.config.Props;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class HttpCatsTest {

    @DataProvider(name="statuses-provider")
    public Object[][] provideStatuses() {
        return new Object[][] {{"101"}, {"103"}, {"200"}, {"201"},
                {"205"}, {"304"}, {"305"}, {"400"}, {"402"}, {"417"}, {"418"}, {"500"}, {"530"}
        };
    }

    @Test(description = "Проверяем разные коды", dataProvider = "statuses-provider")
    public void shouldReturnStatusCodeData(String status) throws IOException {
        new Props("httpcat");
        new HttpClient(
                new HttpAttributes(Props.url, status))
                .getRequest()
                .then()
                .statusCode(200);
    }

    @Test(description = "Проверяем картинки разных кодов", dataProvider = "statuses-provider")
    public void shouldReturnStatusCodeImages(String status) throws IOException {
        File outputImageFile = new File(String.format("src/test/java/resources/httpcats/%s.jpg", status));
        if (!outputImageFile.exists()) {
            new Props("httpcat");
            byte[] image = RestAssured.given()
                    .when()
                    .get(Props.url + String.format("images/%s.jpg", status))
                    .asByteArray();
            OutputStream outStream = new FileOutputStream(outputImageFile);
            outStream.write(image);
            outStream.close();
        }
    }
}
