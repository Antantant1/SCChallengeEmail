import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {
    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter ID:");
    String id;
    try {
      id = bf.readLine();
      bf.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    String urlRepresentation = "https://www.ecs.soton.ac.uk/people/" + id;
    Pattern p = Pattern.compile("^\\<meta property\\=\\\"og\\:title\\\" content\\=\\\"(.*)\\\" \\/>$");
    try {
      URL url = new URL(urlRepresentation);
      URLConnection urlConnection = url.openConnection();
      BufferedReader urlReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
      String line;
      while((line = urlReader.readLine()) != null){
        line = line.trim();
        Matcher m = p.matcher(line);
        if(m.matches()){
          String name = m.group(1);
          System.out.println(name);
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}