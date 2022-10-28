public class Decrement extends UnaryFunction {
  public Decrement(String variableName) {
    super(variableName);
  }

  @Override
  public void execute(Program p) {
    super.execute(p);
    variable.numberFunction(MathFunction.DECR);
  }
}
