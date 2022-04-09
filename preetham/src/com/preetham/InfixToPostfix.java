package com.preetham;

import java.util.Stack;

public class InfixToPostfix {
    static int precedence(char ch) {
        switch (ch) {
            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }
        return -1;
    }

    static String toPostFix(String str) {
        Stack<Character> stack = new Stack<>();
        StringBuilder builder = new StringBuilder();
        String result = new String("");

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                builder.append(ch);
                result += ch;
            }
            else if (ch == '(') {
                stack.push(ch);
            }
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    // builder.append(stack.peek());
                    result += stack.peek();
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    stack.pop(); // poping '('
                }
            } else {
                while (!stack.isEmpty() && precedence(ch) <= precedence(stack.peek())) {
                    // builder.append(stack.peek());
                    result += stack.peek();
                    stack.pop();
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            result += stack.pop();
        }

        return result;
    }

    public static void main(String[] args) {
        var res = toPostFix("(a-b/c)*(a/k-l)");
        System.out.println(res);
    }
}
