import java.io.IOException;

public class Main {

  private static int port = 2011;

  public static void main(String[] args) {
    try {
      Server server = new Server(port);
    } catch (IOException e) {
      System.err.println("Server failed to open");
    }
  }
}