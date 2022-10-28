public class Increment extends UnaryFunction {

    public Increment(String variableName) {
        super(variableName);
    }

    @Override
    public void execute(Program p) {
        super.execute(p);
        variable.numberFunction(MathFunction.INCR);
    }
}
