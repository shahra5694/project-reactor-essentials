package EvaluteMethematicalExpression;

import java.util.LinkedList;
import java.util.Stack;

public class InfixToPostFix {

    public static void main(String[] args) {
        String infix1 = "2+3-1";
        LinkedList<String> postFix1 = infixToPostFix(infix1);
        System.out.println(String.join(" ", postFix1));
        System.out.println("final result for "+ infix1 + " = " + evaluateExpression(postFix1));

        String infix2 = "2+3*4";
        LinkedList<String> postFix2 = infixToPostFix(infix2);
        System.out.println(String.join(" ", postFix2));
        System.out.println("final result for "+ infix2 + " = " + evaluateExpression(postFix2));


        String infix3 = "3*(4+5)-6/(1+2)";
        LinkedList<String> postFix3 = infixToPostFix(infix3);
        System.out.println(String.join(" ", postFix3));
        System.out.println("final result for "+ infix3 + " = " + evaluateExpression(postFix3));

        String infix4 = "100*(2+12)/7";
        LinkedList<String> postFix4 = infixToPostFix(infix4);
        System.out.println(String.join(" ", postFix4));
        System.out.println("final result for "+ infix4 + " = " + evaluateExpression(postFix4));
    }

    static LinkedList<String> infixToPostFix(String exp) {
        char[] token = exp.toCharArray();
        Stack<Character> operator = new Stack<>();
        LinkedList<String> postfix = new LinkedList<>();

        for (int i = 0; i < token.length; i++) {
            if (token[i] == '(') {
                operator.push(token[i]);
            } else if (token[i] >= '0' && token[i] <= '9') {
                StringBuilder sb = new StringBuilder();
                while (i < token.length && token[i] >= '0' && token[i] <= '9') {
                    sb.append(token[i++]);
                }
                postfix.add(sb.toString());
                i--;
            } else if (isOperator(token[i])) {
                if (operator.isEmpty()) {
                    operator.push(token[i]);
                } else {
                    if (token[i] == '+' || token[i] == '-' || token[i] == '*' || token[i] == '/') {
                        if (getPriority(token[i]) > getPriority(operator.peek())) {
                            operator.push(token[i]);
                        } else {
                            postfix.add(String.valueOf(operator.pop()));
                            operator.push(token[i]);
                        }
                    }
                }
            } else if (token[i] == ')') {
                while (operator.peek() != '(') {
                    postfix.add(String.valueOf(operator.pop()));
                }
                operator.pop();
            }
        }

        while (!operator.isEmpty()) {
            postfix.add(String.valueOf(operator.pop()));
        }

        return postfix;
    }

    static int getPriority(char c) {
        if (c == '+' || c == '-') {
            return 1;
        } else if (c == '*' || c == '/') {
            return 2;
        }
        return 0;
    }

    static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    static int evaluateExpression(LinkedList<String> postFix) {
        Stack<Integer> stack = new Stack<>();
        while (!postFix.isEmpty()) {
            if (parseInt(postFix.peek())) {
                stack.push(Integer.parseInt(postFix.pop()));
            } else {
                int n2 = stack.pop();
                int n1 = stack.pop();
                stack.push(applyOperator(postFix.pop().charAt(0), n1, n2));
            }

        }
        return stack.pop();
    }


    static boolean parseInt(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException n) {
            return false;
        }
    }

    static int applyOperator(char operator, int a, int b) {
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0) {
                    throw new UnsupportedOperationException("Cannot divide by zero");
                }
                return a / b;
        }
        return 0;
    }
}
