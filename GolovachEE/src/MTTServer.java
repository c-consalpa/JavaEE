import com.sun.deploy.net.HttpUtils;
import jdk.jfr.events.SocketReadEvent;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

// Emulation of EOF sent by the server
public class MTTServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(80);
        while (true) {
            Socket clientSocket = serverSocket.accept();
            new SocketTask(clientSocket);
        }


//        while(true) {
//
//        }
    }
}

class SocketTask implements Runnable {
    private Socket clientSocket;

    public SocketTask(Socket sck) {
        this.clientSocket = sck;
    }

    @Override
    public void run() {

    }
}