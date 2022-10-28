public class Add extends BinaryFunction{
    public Add(String variableName1, String variableName2) {
        super(variableName1, variableName2);
    }

    @Override
    public void execute(Program p) {
        super.execute(p);
        variable1.numberFunction(MathFunction.ADD, variable2);
    }
}
