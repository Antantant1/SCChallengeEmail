import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ServerWriter implements Runnable {

  private PrintWriter output;

  public ServerWriter(PrintWriter output) {
    this.output = output;
  }

  @Override
  public void run() {
    while (true) {
      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
      try {
        String input = bf.readLine();
        output.println("[Server]: " + input);
      } catch (IOException e) {

      }
    }
  }
}
