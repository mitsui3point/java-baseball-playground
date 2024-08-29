package calculator.service;


import calculator.dto.Operand;
import calculator.enums.Operator;
import calculator.exception.CalculatorException;

public class Calculator {
  private Integer result = 0;

  public static final String SPACE = " ";

  public Integer calculate(String formula) throws CalculatorException {
    Operand operand = new Operand();
    Operator operator = null;
    String[] values = getValues(formula);
    result = parseStringToInteger(values[0], 0);
    for (int i = 0; i < values.length; i++) {
      String value = values[i];
      operand = getOperand(operand, value, i);
      operator = getOperator(operator, value, i);
      setResult(operand, operator, i);
    }
    return result;
  }

  private String[] getValues(String formula) {
    return formula.split(SPACE);
  }

  private Operator getOperator(Operator prevOperator, String value, Integer index) throws CalculatorException {
    if (isSetOperatorTurn(index)) {
      return Operator.extract(value);
    }
    return prevOperator;
  }

  private Operand getOperand(Operand prevOperand, String value, Integer index) throws CalculatorException {
    if (isSetOperandTurn(index)) {
      return new Operand(result, parseStringToInteger(value, index));
    }
    return prevOperand;
  }

  private void setResult(Operand operand, Operator operator, int i) {
    boolean isPossibleToCalculate = isSetOperandTurn(i) && !isInitial(i);
    if (isPossibleToCalculate) {
      result = operator
              .getFunction()
              .apply(operand);
    }
  }

  private int parseStringToInteger(String value, Integer index) throws CalculatorException {
    try {
      return Integer.parseInt(value);
    } catch (NumberFormatException e) {
      throw new CalculatorException((index + 1) + "번째 자리는 피연산자(숫자)만 올 수 있습니다. 현재자리 값:" + value);
    }
  }

  private boolean isInitial(int i) {
    return i == 0;
  }

  private boolean isSetOperandTurn(Integer index) {
    return index % 2 == 0;
  }

  private boolean isSetOperatorTurn(Integer index) {
    return index % 2 == 1;
  }
}