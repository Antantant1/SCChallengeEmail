import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter filename: ");
        try {
            Parser parse = new Parser(System.getProperty("user.dir") + "/SampleCode/" + bf.readLine() + ".txt");
            Program p = new Program(parse.getStatements());
            p.execute(p);
        } catch (IOException e) {
            System.err.println("File not Found");
        }
    }
}