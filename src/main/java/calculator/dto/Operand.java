package calculator.dto;

public class Operand {
  private final Integer previous;
  private final Integer current;

  public Operand() {
    this.previous = null;
    this.current = null;
  }

  public Operand(Integer previous, Integer current) {
    this.previous = previous;
    this.current = current;
  }

  public Integer getPrevious() {
    return previous;
  }

  public Integer getCurrent() {
    return current;
  }

  @Override
  public String toString() {
    return "Operand{" +
            "previous=" + previous +
            ", current=" + current +
            '}';
  }
}
