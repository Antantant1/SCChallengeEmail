public enum Compare {
    NOT,
    EQ,
    LEQ,
    GEQ,
    L,
    G;

    public boolean check(Variable v1, Variable v2){
        return switch(this){
            case NOT -> !equality(v1, v2);
            case EQ -> equality(v1, v2);
            case LEQ -> lessThan(v1, v2) || equality(v1, v2);
            case GEQ -> greaterThan(v1, v2) || equality(v1, v2);
            case L -> lessThan(v1, v2);
            case G -> greaterThan(v1, v2);
        };
    }

    private boolean equality(Variable v1, Variable v2) {
        return v1.getData().equals(v2.getData());
    }

    private boolean lessThan(Variable v1, Variable v2) {
        return ((Number) v1.getData()).compareTo((Number) v2.getData()) < 0;
    }

    private boolean greaterThan(Variable v1, Variable v2) {
        return ((Number) v1.getData()).compareTo((Number) v2.getData()) > 0;
    }
}
