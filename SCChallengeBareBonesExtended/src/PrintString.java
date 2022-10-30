import java.util.Arrays;

public class PrintString implements Statement {

    private String str;

    public PrintString(String[] strs) {
        str = "";
        for (int i = 1; i < strs.length; i++) {
            str += strs[i] + " ";
        }
        str.trim();
    }

    @Override
    public void execute(Program p) {
        System.out.println(str);
    }
}
