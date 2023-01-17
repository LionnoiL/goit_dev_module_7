import java.util.Scanner;

public class HttpImageStatusCli {

    public static void main(String[] args) {
        new HttpImageStatusCli().askStatus();
    }

    public void askStatus() {

        final String ENTER_CODE_MESSAGE = "Enter HTTP status code or 'exit' -> ";
        final String ENTER_VALID_CODE_MESSAGE = "Please enter valid number -> ";
        final String NOT_IMAGE_MESSAGE = "There is not image for HTTP status";

        Scanner scanner = new Scanner(System.in);
        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
        int code = 0;

        System.out.print(ENTER_CODE_MESSAGE);

        while (scanner.hasNext()) {
            if (scanner.hasNextLine()) {
                String codeString = scanner.nextLine();

                if ("exit".equals(codeString)) {
                    return;
                }

                try {
                    code = Integer.parseInt(codeString);
                } catch (RuntimeException e) {
                    System.out.print(ENTER_VALID_CODE_MESSAGE);
                    continue;
                }

                try {
                    downloader.downloadStatusImage(code);
                } catch (RuntimeException e) {
                    System.out.println(NOT_IMAGE_MESSAGE + code);
                }

                System.out.print(ENTER_CODE_MESSAGE);
            }
        }

        scanner.close();
    }

}
