public class Condition {
  private Variable v1;
  private Variable v2;
  private Compare compare;

  public Condition(String s1, String s2, Compare compare, Program p) {
    v1 = p.getVariable(s1);
    if (v1 == null) {
      v1 = new Variable(s1, Integer.parseInt(s1));
      p.addVariable(v1);
    }
    v2 = p.getVariable(s2);
    if (v2 == null) {
      v2 = new Variable(s2, Integer.parseInt(s2));
      p.addVariable(v2);
    }
    this.compare = compare;
  }

  public boolean checkCondition() {
    return switch (compare) {
      case NOT -> !equality();
    };
  }

  private boolean equality() {
    return v1.getData() == v2.getData();
  }
}
