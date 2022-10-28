public abstract class UnaryFunction implements Statement {
  private String variableName;
  protected Variable variable;

  public UnaryFunction(String variableName) {
    this.variableName = variableName;
  }

  public void setVariable(Program p) { //either creates the variable or get the variable reference to this function
    variable = p.getVariable(variableName);
    if (variable == null) {
      System.err.println("No such variable");
    }
  }

  public void createVariable(){
    variable = new Variable(variableName);
  }

  @Override
  public void execute(Program p) {
    if (variable == null) setVariable(p);
  }
}
