package calculator;

import calculator.exception.CalculatorException;
import calculator.view.View;


public class Application {
  public static void main(String[] args) throws CalculatorException {
    View view = new View();
    view.inputRequest();
    view.printResult();
  }

}
