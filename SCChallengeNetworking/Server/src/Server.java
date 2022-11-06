import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

  private ServerSocket serverSocket; //server socket
  private Socket clientSocket; //client's socket
  private PrintWriter output; //output to client
  private BufferedReader input; //input from client

  public Server(int port) throws IOException {
    serverSocket = new ServerSocket(port);
    System.out.println("Waiting for connection");
    clientSocket = serverSocket.accept();
    System.out.println("Connection established");
    output = new PrintWriter(clientSocket.getOutputStream(), true);
    input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    run();
  }

  private void run() {
    Thread writeThread = new Thread(new ServerWriter(output));
    writeThread.start();
    while (true) {
      try {
        String read = input.readLine();
        if (read == null) {
          throw new IOException("Read is null");
        }
        System.out.println(read);
      } catch (IOException e) {
        System.err.println("Client Disconnected");
        return;
      }
    }
  }
}
