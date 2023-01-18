import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HttpStatusCheckerTest {

    @Test
    void getStatusImage200() {
        String status = new HttpStatusChecker().getStatusImage(200);
        Assertions.assertEquals("https://http.cat/200.jpg", status);
    }

    @Test
    void getStatusImage404() {
        String status = new HttpStatusChecker().getStatusImage(404);
        Assertions.assertEquals("https://http.cat/404.jpg", status);
    }

    @Test
    void getStatusImage1000() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            new HttpStatusChecker().getStatusImage(1000);
        });
    }

    @Test
    void getStatusImageNegative() {
        Assertions.assertThrows(RuntimeException.class, () -> {
            new HttpStatusChecker().getStatusImage(-1);
        });
    }
}