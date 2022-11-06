import java.io.BufferedReader;
import java.io.IOException;

public class ServerReader implements Runnable {

  private BufferedReader input;
  private boolean kill = false;

  public ServerReader(BufferedReader input) {
    this.input = input;
  }

  @Override
  public void run() {
    while (!kill) {
      try {
        System.out.println(input.readLine());
      } catch (IOException e) {

      }
    }
  }

  public void kill() {
    kill = true;
  }
}
