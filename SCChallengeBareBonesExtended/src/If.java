import java.util.HashMap;

public class If extends Program {

    private String var1;
    private String var2;
    private Compare compareType;
    private Else e;
    private Condition condition;

    public If(String varName1, String compareType, String varName2) {
        var1 = varName1;
        var2 = varName2;
        this.compareType = Compare.valueOf(compareType);
    }

    private void addCondition(Program p) {
        condition = new Condition(var1, var2, compareType, this);
    }

    public void setElse(Else e) {
        this.e = e;
    }

    @Override
    public void execute(Program p) {
        if (condition == null) {
            variables = new HashMap<>(p.variables);
            addCondition(p);
        }
        if (condition.checkCondition()) {
            super.execute(p);
        } else {
            if(e != null) e.runElse(p);
        }
    }
}
