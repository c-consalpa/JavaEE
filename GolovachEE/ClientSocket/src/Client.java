import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 9090);
        try(
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();
                ) {


            byte[] data = "hello".getBytes();
            Scanner scanner = new Scanner(System.in);

            while(true) {
               if (scanner.hasNextLine()) {
                   String line = scanner.nextLine();
                   if (line.equals("aaa")) {
                       outputStream.flush();
                       outputStream.close();
                       break;
                   }
                   System.out.println("writing data: " + line);
                   outputStream.write(line.getBytes(StandardCharsets.UTF_8));
                   outputStream.flush();
               }


//                int bt;
//                while ((bt = inputStream.read(new byte[])) != -1) {
//                    System.out.println("Received from server: " + bt);
//                }
            }
        }
    }
}
