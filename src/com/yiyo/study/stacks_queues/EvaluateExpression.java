package com.yiyo.study.stacks_queues;

import java.util.Stack;

public class EvaluateExpression {

    /*
    Evaluate the value of an arithmetic expression in Reverse Polish Notation.
    Valid operators are +, -, *, /. Each operand may be an integer or another expression.

    Examples:
    ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
    ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
     */
    public static void main(String[] args) {
        EvaluateExpression expression = new EvaluateExpression();
        String[] A = {"2", "1", "+", "3", "*"};
        String[] B = {"4", "13", "5", "/", "+"};
        System.out.println(expression.evalRPN(A));
        System.out.println(expression.evalRPN(B));
    }

    private int evalRPN(String[] A) {
        Stack<Integer> stack = new Stack<>();

        for (String value : A) {
            if (value.equals("+") || value.equals("-") || value.equals("*") || value.equals("/")) {
                int right = stack.pop();
                int left = stack.pop();
                switch (value) {
                    case "+":
                        stack.push(right + left);
                        break;
                    case "-":
                        stack.push(left - right);
                        break;
                    case "*":
                        stack.push(right * left);
                        break;
                    case "/":
                        stack.push(left / right);
                }
            } else {
                stack.push(Integer.parseInt(value));
            }
        }
        return stack.pop();
    }
}
