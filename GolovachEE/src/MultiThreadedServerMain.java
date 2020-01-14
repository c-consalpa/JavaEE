

import sun.misc.OSEnvironment;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;

import static java.nio.charset.StandardCharsets.UTF_8;


public class MultiThreadedServerMain {
    public static void main(String[] args) {
        new Thread(new MultiThreadedServer(9090),"my Server").start();
    }
}

class MultiThreadedServer implements Runnable{

    protected int          serverPort   = 8080;
    protected ServerSocket serverSocket = null;
    protected boolean      isStopped    = false;
    protected Thread       runningThread= null;

    public MultiThreadedServer(int port){
        this.serverPort = port;
    }

    public void run(){
        synchronized(this){
            this.runningThread = Thread.currentThread();
        }
        openServerSocket();
        while(! isStopped()){
            Socket clientSocket = null;
            try {
                clientSocket = this.serverSocket.accept();
            } catch (IOException e) {
                if(isStopped()) {
                    System.out.println("Server Stopped.") ;
                    return;
                }
                throw new RuntimeException(
                        "Error accepting client connection", e);
            }
            new Thread(
                    new RequestHandler(clientSocket, "Multithreaded Server")
            ).start();
        }
        System.out.println("Server Stopped.") ;
    }


    private synchronized boolean isStopped() {
        return this.isStopped;
    }

    public synchronized void stop(){
        this.isStopped = true;
        try {
            this.serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException("Error closing server", e);
        }
    }

    private void openServerSocket() {
        try {
            this.serverSocket = new ServerSocket(this.serverPort);
        } catch (IOException e) {
            throw new RuntimeException("Cannot open port 8080", e);
        }
    }

}


class RequestHandler implements Runnable {
    private Socket clientSocket;
    private InputStream clientIn;
    private OutputStream clientOut;
    private static int cnt;
    private int id = cnt++;
    long time;

    public RequestHandler(Socket clientSocket, String multithreaded_server) {
        time = System.currentTimeMillis();
        this.clientSocket = clientSocket;

    }

    @Override
    public void run() {
        try (
                InputStream clientIn = clientSocket.getInputStream();
                OutputStream clientOut = clientSocket.getOutputStream();
                ) {


            int bt;
            byte[] data = new byte[1024 * 10];
            int cnt = clientIn.read(data);
            String request = new String(data, 0, cnt);
            System.out.println(request);
//                  while((bt = clientIn.read()) != -1) {
//                System.out.print(new String(new byte[]{(byte)bt}));
//            }


            String responseBody =   "<html><body>"            +
                                "RequestHandler: "            +
                                id                            +
                            "\r\nTime: "                      +
                            time                              +
                                "\r\n"                        +
                                "<pre>"                       +
                                request                       +
                                "</pre>"                      +
                                "</body></html>";

            String response  =  ("HTTP/1.1 200 OK\r\n"   +
                                "Content-Type: text/html; charset=UTF-8" +
                                "Content-Length: " + responseBody.length() +
                                "\r\n\r\n" +
                                responseBody);

            clientOut.write(response.getBytes(UTF_8));
            clientOut.flush();

        } catch (IOException e) {
            System.err.println("Can't get clients in/out streams");
            e.printStackTrace();
        }
        System.out.println("request processed ");
    }
}