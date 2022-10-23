public class Increment extends UnaryFunction {

  public Increment(String variableName) {
    super(variableName);
  }

  @Override
  public void execute(Program p) {
    if (variable == null) setVariable(p);
    variable.increment();
  }
}
