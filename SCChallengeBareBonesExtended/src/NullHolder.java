import java.util.ArrayList;
import java.util.List;

public class NullHolder implements Statement {

    private String methodName;
    private List<String> inputArgs;

    public NullHolder(String[] inputs) {
        this.methodName = inputs[0];
        inputArgs = new ArrayList<>();
        for (int i = 1; i < inputs.length; i++) {
            inputArgs.add(inputs[i]);
        }
    }

    @Override
    public void execute(Program p) {
        Variable v = p.getVariable(methodName);
        if (v == null) System.err.println("Invalid Syntax");
        else {
            if (v.getData() instanceof Method) {
                ((Method) v.getData()).runMethod(p, inputArgs);
            }
        }
    }
}
