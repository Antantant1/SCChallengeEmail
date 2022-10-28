import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Program implements Statement {
  private List<Statement> statements;

  protected Map<String, Variable> variables;

  public Program() {
    variables = new HashMap<>();
    statements = new ArrayList<>();
  }

  public Program(List<Statement> statements) {
    this.statements = statements;
    variables = new HashMap<>();
  }

  public void putVariable(Variable variable) {
    variables.put(variable.getName(), variable);
  }

  public Variable getVariable(String name) {
    return variables.get(name);
  }

  public List<Statement> getStatements() {
    return statements;
  }

  public void addVariable(Variable variable) {
    variables.put(variable.getName(), variable);
  }

  public void setStatement(List<Statement> statements) {
    this.statements = statements;
  }

  @Override
  public void execute(Program p) {
    for (Statement ex : statements) {
      ex.execute(p);
    }
  }

  public void printVariables() {
    System.out.println(variables);
  }
}
