import java.util.HashMap;

public class Else extends Program {

    public void runElse(Program p) {
        variables = new HashMap<>(variables);
        super.execute(p);
    }

    @Override
    public void execute(Program p) {

    }
}
