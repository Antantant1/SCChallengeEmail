public class Method extends Program implements Data {
    protected String methodName;

    public Method() {
        super();
    }

    public Method(String methodName) {
        this.methodName = methodName;
    }

    @Override
    public String toString() {
        return methodName;
    }
}