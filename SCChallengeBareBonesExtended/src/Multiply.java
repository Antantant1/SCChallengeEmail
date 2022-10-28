public class Multiply extends BinaryFunction {
    public Multiply(String variableName1, String variableName2) {
        super(variableName1, variableName2);
    }

    @Override
    public void execute(Program p) {
        super.execute(p);
        variable1.numberFunction(MathFunction.MULTIPLY, variable2);
    }
}
