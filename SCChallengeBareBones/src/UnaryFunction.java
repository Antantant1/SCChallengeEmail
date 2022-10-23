public abstract class UnaryFunction implements Statement {
  private String variableName;
  protected Variable variable;

  public UnaryFunction(String variableName) {
    this.variableName = variableName;
  }

  public void setVariable(Program p) { //either creates the variable in the map or get the variable reference to this function
    variable = p.getVariable(variableName);
    if (variable == null) {
      variable = new Variable(variableName);
    }
  }
}
