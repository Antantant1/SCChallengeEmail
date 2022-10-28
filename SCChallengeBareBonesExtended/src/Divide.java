public class Divide extends BinaryFunction {
    public Divide(String variableName1, String variableName2) {
        super(variableName1, variableName2);
    }

    @Override
    public void execute(Program p) {
        super.execute(p);
        variable1.numberFunction(MathFunction.DIVIDE, variable2);
    }
}
