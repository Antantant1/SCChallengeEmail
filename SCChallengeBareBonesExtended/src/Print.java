public class Print extends UnaryFunction{

    public Print(String variableName) {
        super(variableName);
    }

    @Override
    public void execute(Program p) {
        super.execute(p);
        System.out.println(variable);
    }
}
