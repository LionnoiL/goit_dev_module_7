import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class HttpUtils {

    private HttpUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static int getRequestStatus(String url) {

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpUriRequest request = new HttpGet(url);
            HttpResponse response = httpClient.execute(request);
            return response.getStatusLine().getStatusCode();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static byte[] getRequestBody(String url) {

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpUriRequest request = new HttpGet(url);
            HttpResponse response = httpClient.execute(request);
            return response.getEntity().getContent().readAllBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
