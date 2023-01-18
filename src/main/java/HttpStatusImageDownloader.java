import java.io.FileOutputStream;
import java.io.IOException;

public class HttpStatusImageDownloader {
    public void downloadStatusImage(int code) {
        String imageUrl = new HttpStatusChecker().getStatusImage(code);
        byte[] bytes = HttpUtils.getRequestBody(imageUrl);

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(code + ".jpg");
            fos.write(bytes);
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
