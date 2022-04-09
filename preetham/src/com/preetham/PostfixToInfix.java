package com.preetham;

import java.util.List;
import java.util.Stack;

public class PostfixToInfix {

    static String toInfix(String str){
        Stack<String> stack = new Stack<>();
        List<Character> operator = List.of('+','-','*','/','^');

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if ((ch>= 'a' && ch<='z') || (ch>='A' && ch<= 'B')){
                stack.push(Character.toString(ch));
            }
            else if (operator.contains(ch)) {
                var b = stack.peek();
                stack.pop();
                var a = stack.peek();
                stack.pop();
                var exp = '('+a+ch+b+')';
                stack.push(exp);
            }
        }

        return stack.peek();
    }

    public static void main(String[] args) {
        var res = toInfix("ab+c*");
        System.out.println(res);
    }
}
