import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Parser {
  private BufferedReader bf;
  private String filePath;

  public Parser(String filePath) { //Constructor: input the filePath to create the BufferedReader object to the file
    this.filePath = filePath;
    try {
      bf = new BufferedReader(new FileReader(filePath));
    } catch (Exception e) {
      System.err.println(e);
    }
  }

  public String getPath() {
    return filePath;
  }


  public List<Statement> getStatements() {
    List<Statement> statements = new ArrayList<>();
    List<String> stringStatements = new ArrayList<>();
    String line;
        /*
            First Read File line by line and break on every semicolon and store in stringStatements
            e.g.
                  clear X;
                  incr X;           ->      ["clear X", "incr X"]

                  or

                  clear X;incr X;   ->      ["clear X", "incr X"]
        */
    try {
      while ((line = bf.readLine()) != null) {
        String[] current = line.split(";");
        for (String str : current) {
          stringStatements.add(str.trim());
        }
      }
    } catch (Exception e) {
      System.err.println("Cannot read file");
    }
    for (String str : stringStatements) {
      statements.add(stringToStatement(str));
    }
    List<Statement> output = new ArrayList<>();
    processStatements(statements, output);
    return output;
  }

  private Statement stringToStatement(String str) { //syntax rules
    String[] current = str.split(" ");
    return switch (current[0]) {
      case "clear" -> new Clear(current[1]);
      case "incr" -> new Increment(current[1]);
      case "decr" -> new Decrement(current[1]);
      case "while" -> new While(current[1], current[2].toUpperCase(), current[3]);
      case "end" -> new End();
      default -> null;
    };
  }

  private List<Statement> processStatements(List<Statement> statements, List<Statement> output) { //all while objects consume the statements until end is reached
    if (statements.size() == 0) {
      return output;
    }
    Statement current = statements.remove(0);
    if (current instanceof End) {
      return output;
    }
    if (current instanceof While) {
      While whilE = (While) current;
      whilE.setStatement(processStatements(statements, new ArrayList<>()));
    }
    output.add(current);
    return processStatements(statements, output);
  }

  public void printFile() { //print whole file to console
    BufferedReader bf;
    try {
      bf = new BufferedReader(new FileReader(filePath));
      while (true) {
        String line = bf.readLine();
        if (line != null) System.out.println(line);
        else break;
      }
    } catch (Exception e) {
      System.err.println("Cannot read file");
    }
  }
}
