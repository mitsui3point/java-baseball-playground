package calculator.view;

import calculator.service.Calculator;
import calculator.exception.CalculatorException;

import java.util.Scanner;

public class View {
  private String formula;
  public void inputRequest() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("수식을 입력하세요: ");
    formula = scanner.nextLine();
  }
  public void printResult() throws CalculatorException {
    Calculator calculator = new Calculator();
    Integer result = calculator.calculate(formula);
    System.out.println("result = " + result);
  }

}
