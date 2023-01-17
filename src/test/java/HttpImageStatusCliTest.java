import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HttpImageStatusCliTest {

    @Test
    void askStatus200() {
        new HttpImageStatusCli().askStatus();
    }
}