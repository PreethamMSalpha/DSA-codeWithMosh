package com.preetham.Stack;

import java.util.Stack;

public class BalanceExpression {
    public boolean BalanceExpression(String input) {
        if (input == null)
            throw new IllegalArgumentException();

        //[(5+2){(36+24)*8}]
        Stack<Character> stack = new Stack<>();

        for (char ch : input.toCharArray()) {
            if (isLeftExp(ch))
                stack.push(ch);

            if (isRightExp(ch)) {
                if (stack.empty()) return false;

                var top = stack.pop();
                if (isBracketsMatch(top, ch))
                    return false;
            }
        }
        return stack.empty();

    }

    private boolean isLeftExp(char ch) {
        return ch == '(' || ch == '[' || ch == '{' || ch == '<';
    }

    private boolean isRightExp(char ch) {
        return ch == ')' || ch == ']' || ch == '}' || ch == '>';
    }

    private boolean isBracketsMatch(char left, char right) {
        return ((right == ']' && left != '[') ||
                (right == '}' && left != '{') ||
                (right == ')' && left != '(') ||
                (right == '>' && left != '<'));
    }
}

