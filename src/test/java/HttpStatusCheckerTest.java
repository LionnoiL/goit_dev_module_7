import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HttpStatusCheckerTest {

    @Test
    void getStatusImage200() {
        String status = new HttpStatusChecker().getStatusImage(200);
        Assertions.assertNotEquals("404", status);
    }

    @Test
    void getStatusImage1000() {
        String status = new HttpStatusChecker().getStatusImage(1000);
        Assertions.assertEquals("404", status);
    }

    @Test
    void getStatusImageNegative() {
        String status = new HttpStatusChecker().getStatusImage(-1);
        Assertions.assertEquals("404", status);
    }
}