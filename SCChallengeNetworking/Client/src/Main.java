import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter IP:PORT");
    try {
      String[] input = bf.readLine().trim().split(":");
      Client client = new Client(input[0], Integer.parseInt(input[1]));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }
}