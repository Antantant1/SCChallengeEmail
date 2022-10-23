public class Clear extends UnaryFunction {
  public Clear(String variableName) {
    super(variableName);
  }

  @Override
  public void execute(Program p) {
    setVariable(p);
    p.addVariable(variable);
  }
}
