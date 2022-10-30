import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Method extends Program implements Data {
    protected String methodName;
    List<String> args; //method's local variables

    public Method() {
        super();
    }

    public Method(String[] inputs) {
        this.methodName = inputs[1];
        args = new ArrayList<>();
        for (int i = 2; i < inputs.length; i++) {
            args.add(inputs[i]);
        }
    }

    public void runMethod(Program p, List<String> inputArgs) { //use this to execute the method
        if (inputArgs.size() != args.size()) {
            System.err.println("Input Mismatch");
            return;
        }
        variables = new HashMap<>();
        for (int i = 0; i < args.size(); i++) {
            Variable v1 = p.getVariable(inputArgs.get(i));
            if (v1 == null) {
                v1 = new Variable(inputArgs.get(i), new Number(Integer.parseInt(inputArgs.get(i))));
            }
            variables.put(args.get(i), v1);
        }
        super.execute(this);
    }

    @Override
    public String toString() {
        return methodName;
    }

    @Override
    public void execute(Program p) { //override program's execute as that will execute the method
        p.addVariable(new Variable(methodName, this));
    }
}