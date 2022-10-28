public abstract class BinaryFunction implements Statement {
    private String variableName1;
    private String variableName2;
    protected Variable variable1;
    protected Variable variable2;

    public BinaryFunction(String variableName1, String variableName2) {
        this.variableName1 = variableName1;
        this.variableName2 = variableName2;
    }

    public void setVariable(Program p) { //either creates the variable or get the variable reference to this function
        variable1 = p.getVariable(variableName1);
        if (variable1 == null) {
            variable1 = tryCreate(variableName1);
        }
        variable2 = p.getVariable(variableName2);
        if (variable2 == null) {
            variable2 = tryCreate(variableName2);
        }
    }

    private Variable tryCreate(String variableName) {
        Number number = null;
        try {
            number = new Number(Integer.parseInt(variableName));
        } catch (NumberFormatException e) {
            System.err.println(e);
        }
        Variable v = number != null ? new Variable(variableName, number) : null;
        return v;
    }

    @Override
    public void execute(Program p) {
        if (variable1 == null || variable2 == null) setVariable(p);
    }
}
