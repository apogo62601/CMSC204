public class Notation {

  private static NotationQueue<String> nQueue;
  private static NotationStack<String> nStack;
  private final static String OPS = "+-*/";


  private static String stackTop() {
    try {
      return nStack.top();
    } catch (StackUnderflowException e) {
      e.getMessage();
    }
    return null;
  }

  private static String stackPop() {
    try {
      return nStack.pop();
    } catch (StackUnderflowException e) {
      e.getMessage();
    }
    return null;
  }

  private static boolean stackPush(String c) {
    try {
      return nStack.push(c);
    } catch (StackOverflowException e) {
      e.getMessage();
    }
    return false;
  }

  private static boolean enqueue(String c) {
    try {
      return nQueue.enqueue(c);
    } catch (QueueOverflowException e) {
      e.getMessage();
    }
    return false;
  }
  private static String dequeue() {
    try {
      return nQueue.dequeue();
    } catch (QueueUnderflowException e) {
      e.getMessage();
    }
    return null;
  }

  private static int calculatePrec(char a) {
    if (a == '*' || a == '/') {
      return 1;
    } else if (a == '+' || a == '-') {
      return 0;
    }
    return -1;
  }

  private static String applyOperator(String first, String second, char operator)
      throws InvalidNotationFormatException {
    double fir = Double.parseDouble(first);
    double sec = Double.parseDouble(second);
    switch (operator) {
      case '+':
        return Double.toString(fir + sec);
      case '-':
        return Double.toString(fir - sec);
      case '*':
        return Double.toString(fir * sec);
      case '/':
        if (sec == 0)
          throw new InvalidNotationFormatException();
        return Double.toString(fir / sec);
    }
    return null;
  }
  
  public static String convertInfixToPostfix(String complexInfix)
      throws InvalidNotationFormatException {
    nQueue = new NotationQueue<String>();
    nStack = new NotationStack<String>();

    for (int i = 0; i < complexInfix.length(); i++) {
      char letter = complexInfix.charAt(i);
      if (letter == ' ') {
        continue;
      } else if (Character.isDigit(letter)) {
        enqueue(Character.toString(letter));
      } else if (letter == '(') {
        stackPush(Character.toString(letter));
      } else if (OPS.indexOf(letter) >= 0) {
        while (!nStack.isEmpty() && calculatePrec(stackTop().charAt(0)) >= calculatePrec(letter)) {
          enqueue(stackPop());
        }
        stackPush(Character.toString(letter));
      } else if (letter == ')') {
        char top = stackPop().charAt(0);
        while (top != '(') {
          enqueue(Character.toString(top));
          if (nStack.isEmpty()) {
            throw new InvalidNotationFormatException();
          } else {
            top = stackPop().charAt(0);
          }
        }
      }
    }
    while (!nStack.isEmpty()) {
      enqueue(stackPop());
    }
    return nQueue.toString();
  }
  
  public static String convertPostfixToInfix(String complexPostfix)
      throws InvalidNotationFormatException {
    nStack = new NotationStack<String>();
    for (int i = 0; i < complexPostfix.length(); i++) {
      char letter = complexPostfix.charAt(i);
      if (letter == ' ') {
        continue;
      } else if (Character.isDigit(letter)) {
        stackPush(Character.toString(letter));
      } else if (OPS.indexOf(letter) >= 0) {
        String fir = stackPop().toString(), sec, tmp;
        if (nStack.isEmpty()) {
          throw new InvalidNotationFormatException();
        } else {
          sec = stackPop().toString();
          tmp = '(' + sec + letter + fir + ')';
          stackPush(tmp);
        }
      }
    }
    if (nStack.size() != 1) {
      throw new InvalidNotationFormatException();
    }
    return stackPop();
  }

  public static double evaluatePostfixExpression(String complexPostfix)
      throws InvalidNotationFormatException {
    nStack = new NotationStack<String>();
    for (int i = 0; i < complexPostfix.length(); i++) {
      char letter = complexPostfix.charAt(i);
      if (letter == ' ') {
        continue;
      } else if (Character.isDigit(letter) || letter == '(') {
        stackPush(Character.toString(letter));
      } else if (OPS.indexOf(letter) >= 0) {
        String fir = stackPop().toString(), sec;
        String result;
        if (nStack.isEmpty()) {
          throw new InvalidNotationFormatException();
        } else {
          sec = stackPop().toString();
          result = applyOperator(sec, fir, letter);
          stackPush(result);
        }
      }
    }
    if (nStack.size() != 1) {
      throw new InvalidNotationFormatException();
    }
    return Double.parseDouble(stackPop());
  }

  public static double evaluateInfixExpression(String infixExpr) {
    String postfixExpression = convertInfixToPostfix(infixExpr);
    return evaluatePostfixExpression(postfixExpression);
  }

}