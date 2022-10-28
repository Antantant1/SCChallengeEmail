public class Clear extends UnaryFunction {
    public Clear(String variableName) {
        super(variableName);
    }

    @Override
    public void execute(Program p) {
        createVariable();
        p.addVariable(variable);
        setVariable(p);
        variable.numberFunction(MathFunction.CLEAR);
    }
}
