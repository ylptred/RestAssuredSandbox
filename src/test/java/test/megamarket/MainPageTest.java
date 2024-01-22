package test.megamarket;

import org.example.utils.http.HttpAttributes;
import org.example.utils.http.HttpClient;
import org.testng.annotations.Test;
import org.example.utils.config.Props;

import java.io.IOException;

import static org.hamcrest.Matchers.lessThan;

public class MainPageTest {

    @Test(description = "Проверяем доступность сервиса СберМегаМаркет")
    public void shouldReturnDate() throws IOException {
        new Props();
        new HttpClient(
                new HttpAttributes(Props.url))
                .getRequest()
                .then()
                .statusCode(200)
                .time(lessThan(5000L));
    }
}
