public class Variable {
  private String name;
  private int data;

  public Variable(String name) {
    this.name = name;
  }

  public Variable(String name, int data) {
    this.name = name;
    this.data = data;
  }

  public String getName() {
    return name;
  }

  public void decrement() {
    data--;
  }

  public void increment() {
    data++;
  }

  public void clear() {
    data = 0;
  }

  public int getData() {
    return data;
  }

  @Override
  public String toString() {
    return Integer.toString(data);
  }
}
