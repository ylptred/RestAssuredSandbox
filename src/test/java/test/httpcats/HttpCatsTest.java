package test.httpcats;

import org.example.utils.http.HttpAttributes;
import org.example.utils.http.HttpClient;
import org.testng.annotations.Test;
import org.example.utils.config.Props;

import java.io.IOException;

public class HttpCatsTest {

    @Test(description = "Проверяем код 100")
    public void shouldReturnStatusCodeData() throws IOException {
        new Props("httpcat");
        new HttpClient(
                new HttpAttributes(Props.url, "100"))
                .getRequest()
                .then()
                .statusCode(200);
    }

}
