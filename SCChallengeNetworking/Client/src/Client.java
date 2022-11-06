import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

  private String ip;
  private int port;
  private Socket clientSocket; //client's socket
  private PrintWriter output; //write to server
  private BufferedReader input; //read from server
  private String name;
  private ServerReader serverReader;
  public Client(String ip, int port){
    this.ip = ip;
    this.port = port;
    try {
      connect();
      run();
      stop();
    } catch (IOException e) {
      System.err.println("Cannot connect");
    }
  }

  private void connect() throws IOException {
    clientSocket = new Socket(ip, port);
    output = new PrintWriter(clientSocket.getOutputStream(), true);
    input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
  }

  private void run() throws IOException{
    serverReader = new ServerReader(input);
    Thread readThread = new Thread(serverReader);
    readThread.start();
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter name");
    this.name = bf.readLine().trim();
    while(true){
      String input = bf.readLine();
      switch(input){
        case "close" -> {
          return;
        }
        default -> output.println("[" + name + "]: " + input);
      }
    }
  }

  private void stop() throws IOException {
    input.close();
    output.close();
    clientSocket.close();
    serverReader.kill();
  }
}
