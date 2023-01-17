import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HttpStatusImageDownloaderTest {

    @Test
    void downloadStatusImage() {
        new HttpStatusImageDownloader().downloadStatusImage(200);
    }

    @Test
    void downloadStatusImageException() {
        Assertions.assertThrows(RuntimeException.class, ()->new HttpStatusImageDownloader().downloadStatusImage(1000));
    }
}