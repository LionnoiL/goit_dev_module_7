import java.util.Scanner;

public class HttpImageStatusCli {

    public static void main(String[] args) {
        new HttpImageStatusCli().askStatus();
    }

    public void askStatus() {

        final String ENTER_CODE_MESSAGE = "Enter HTTP status code ";
        final String ENTER_VALID_CODE_MESSAGE = "Please enter valid number";
        final String NOT_IMAGE_MESSAGE = "There is not image for HTTP status ";

        Scanner scanner = new Scanner(System.in);
        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
        int code = 0;

        System.out.print(ENTER_CODE_MESSAGE);

        while (scanner.hasNext()) {


            if (scanner.hasNextInt()){
                try {
                    code = scanner.nextInt();
                } catch (RuntimeException e) {
                    System.out.println(ENTER_VALID_CODE_MESSAGE);
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
