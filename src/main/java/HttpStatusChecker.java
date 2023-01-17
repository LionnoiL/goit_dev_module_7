public class HttpStatusChecker {

    public String getStatusImage(int code) {

        String url = "https://http.cat" + "/" + code + ".jpg";

        int statusCode = HttpUtils.getRequestStatus(url);

        if (statusCode == -1 || statusCode == 404) {
            return "404";
        } else {
            return url;
        }

    }

}


