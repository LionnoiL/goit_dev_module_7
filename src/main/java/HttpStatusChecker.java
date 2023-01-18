public class HttpStatusChecker {

    public String getStatusImage(int code) {

        String url = "https://http.cat" + "/" + code + ".jpg";

        int statusCode = HttpUtils.getRequestStatus(url);

        if (statusCode == -1 || statusCode == 404) {
            throw new RuntimeException("Image not found");
        } else {
            return url;
        }

    }

}


