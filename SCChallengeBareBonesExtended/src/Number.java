public class Number implements Data{
    private int num;

    public Number(){
        num = 0;
    }
    public Number(int num){
        this.num = num;
    }

    public void increment(){
        num++;
    }

    public void decrement(){
        num--;
    }

    public void clear(){
        num = 0;
    }

    public void add(Number n){
        num += n.num;
    }

    public void minus(Number n){
        num -= n.num;
    }

    public void multiply(Number n){
        num *= n.num;
    }

    public void divide(Number n){
        num /= n.num;
    }

    @Override
    public String toString() {
        return Integer.toString(num);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == this) return true;
        if(!(obj instanceof Number)) return false;
        Number n1 = (Number) obj;
        return num == n1.num;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(num);
    }
}
