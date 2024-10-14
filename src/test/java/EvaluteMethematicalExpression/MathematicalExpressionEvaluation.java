package EvaluteMethematicalExpression;

import java.util.Stack;

public class MathematicalExpressionEvaluation {

    public static void main(String[] args) {
//        System.out.println(evaluateString("10 + 2 * 6"));
//        System.out.println(evaluateString("100 * 2 + 12"));
        System.out.println(evaluateString("100*(2+12)"));
//        System.out.println(evaluateString("100 * ( 2 + 12 ) / 7"));
    }

    static int evaluateString(String expression) {
        char [] tokens = expression.toCharArray();

        // stack of numbers
        Stack<Integer> values = new Stack<>();

        // stack of operator
        Stack<Character> operator = new Stack<>();
        for(int i = 0; i< tokens.length;i++) {
            // current token is white space then skip it.
            if(tokens[i]==' ')
                continue;

            // current token is number then push it to stack.

            if (tokens[i] >= '0' && tokens[i] <='9') {
                StringBuilder sb = new StringBuilder();

                // there may be more than one digit in number.

                while (i< tokens.length && tokens[i] >= '0' && tokens[i] <='9') {
                    sb.append(tokens[i++]);
                }
                values.push(Integer.parseInt(sb.toString()));

                // right now the i points to the character next to the digit since the for loop also increase the i then it would skip
                // one token position , we need to decrease the position of i by 1 to correct the offset.
                i--;
            }
            // current token is an opening brace. push it to ops stack.
            else if(tokens[i]=='(') {
                operator.push(tokens[i]);
            }

            // closing braces encountered solve the entire brace.
            else if(tokens[i]==')') {
                while (operator.peek() != '(') {
                   values.push(applyOperator(operator.pop(),values.pop(),values.pop()));
                }
                operator.pop();
            }

            // current token is an operator.
            if(tokens[i] == '+' || tokens[i] == '-' || tokens[i]=='*' || tokens[i] == '/') {

                // while top of operator has greater or same precedence to current token , which is an operator
                // apply operator from top of operator stack to the top two element of value stack.
                while (!operator.empty() && hasPrecedence(tokens[i],operator.peek())) {
                   values.push(applyOperator(operator.pop(),values.pop(),values.pop()));
                }
                operator.push(tokens[i]);
            }
        }

        // entire expression has been parsed at this point. apply remaining operator to remaining values.
        while (!operator.isEmpty()) {
            values.push(applyOperator(operator.pop(),values.pop(),values.pop()));
        }
        return values.pop();
    }

    // return true if op2 has higher or same precedence as op1. else return false.
    static boolean hasPrecedence(char op1, char op2) {
        if(op2=='(' || op2 == ')')
            return false;
        if((op1 == '*' || op1 == '/') && (op2 == '-' || op2 == '+')) {
            return false;
        }
        else
            return true;
    }


    static int applyOperator(char operator, int a,int b) {
            switch (operator) {
                case '+' :
                    return a+b;
                case '-':
                    return a-b;
                case '*':
                    return a*b;
                case '/':
                    if(b==0) {
                        throw new UnsupportedOperationException("Cannot divide by zero");
                    }
                    return a/b;
            }
            return 0;
    }
}
