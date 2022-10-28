public class PrintString implements Statement {

    private String str;

    public PrintString(String[] strs) {
        for (int i = 1; i < strs.length; i++) {
            str += strs[i] + " ";
        }
        str.trim();
    }

    @Override
    public void execute(Program p) {
        System.err.println(str);
        System.out.print(str);
    }
}
