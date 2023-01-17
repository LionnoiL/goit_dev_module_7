import java.io.FileOutputStream;
import java.io.IOException;

public class HttpStatusImageDownloader {

    public void downloadStatusImage(int code) {
        String status = new HttpStatusChecker().getStatusImage(code);
        if (status.equals("404")) {
            throw new RuntimeException("Image not found");
        }

        byte[] bytes = HttpUtils.getRequestBody("https://http.cat" + "/" + code + ".jpg");

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
