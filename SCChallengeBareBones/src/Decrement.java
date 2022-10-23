public class Decrement extends UnaryFunction {
  public Decrement(String variableName) {
    super(variableName);
  }

  @Override
  public void execute(Program p) {
    if (variable == null) setVariable(p);
    variable.decrement();
  }
}
