import java.util.HashMap;

public class While extends Method {
    private Condition condition;
    private String var1;
    private String var2;
    private Compare compareType;

    public While(String varName1, String compareType, String varName2) {
        methodName = "While";
        var1 = varName1;
        var2 = varName2;
        this.compareType = Compare.valueOf(compareType);
    }

    private void addCondition(Program p) {
        condition = new Condition(var1, var2, compareType, this);
    }


    @Override
    public void execute(Program p) {
        if (condition == null) { //on first execute
            variables = new HashMap<>(p.variables);
            addCondition(p);
        }
        while (condition.checkCondition()) { //loop through statements as long as condition is met
            for (Statement statement : getStatements()) {
                statement.execute(this);
            }
        }
    }
}
