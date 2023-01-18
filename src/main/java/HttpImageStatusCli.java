import java.util.Scanner;

public class HttpImageStatusCli {
    private final String ENTER_CODE_MESSAGE = "Enter HTTP status code or 'exit' -> ";
    private final String ENTER_VALID_CODE_MESSAGE = "Please enter valid number -> ";
    private final String NOT_IMAGE_MESSAGE = "There is not image for HTTP status ";

    public void askStatus() {
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
