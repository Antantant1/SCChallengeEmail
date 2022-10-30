public class Variable implements Data {
    private String name;
    private Data data;

    public Variable(String name) {
        this.name = name;
        this.data = new Number();
    }

    public Variable(String name, Data data) {
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    /*
     * Methods for Number Data
     * */
    public void numberFunction(MathFunction function) { //for unary number functions
        if (!isNumber()) return;
        Number n = (Number) data;
        switch (function) {
            case INCR -> n.increment();
            case DECR -> n.decrement();
            case CLEAR -> n.clear();
            default -> System.err.println("Undefined Unary Math Function");
        }
    }

    public void numberFunction(MathFunction function, Variable variable) {
        if (!isNumber() || !variable.isNumber()) return;
        Number n = (Number) data;
        Number n1 = (Number) variable.data;
        switch (function) {
            case ADD -> n.add(n1);
            case MINUS -> n.minus(n1);
            case MULTIPLY -> n.multiply(n1);
            case DIVIDE -> n.divide(n1);
            default -> System.err.println("Undefined Binary Math Function");
        }
    }

    public Data getData() {
        return data;
    }

    public void execute(Program p) { //method data only
        if (!isMethod()) return;
        Method m = (Method) data;
        m.execute(p);
    }

    private boolean isNumber() {
        boolean b = data instanceof Number;
        if (!b) System.err.println("Data is not Number");
        return b;
    }

    private boolean isMethod() {
        boolean b = data instanceof Method;
        if (!b) System.err.println("Data is not Method");
        return b;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}

