import com.sun.deploy.net.HttpUtils;
import jdk.jfr.events.SocketReadEvent;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

// Emulation of EOF sent by the server
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(80);
        while(true) {
            Socket socket = serverSocket.accept();
            System.out.println("Connected: " + socket);
            try (
                    InputStream socketInputStream = socket.getInputStream();
                    OutputStream socketOutputStream = socket.getOutputStream();
                    ) {

                StringBuilder sb = new StringBuilder();
                int symbol;

                while(true) {
                    if ((symbol = socketInputStream.read()) != -1) {
                        System.out.println(symbol);
                    } else {
                        System.out.println("EOF detected");
                        break;
                    }
                }
            break;
            }
        }
    }
}
