public class Minus extends BinaryFunction{
    public Minus(String variableName1, String variableName2) {
        super(variableName1, variableName2);
    }

    @Override
    public void execute(Program p) {
        super.execute(p);
        variable1.numberFunction(MathFunction.MINUS, variable2);
    }
}
