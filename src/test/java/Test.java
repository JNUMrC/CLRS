import chapter13.RedBlackTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author : jnu_mrc jnu_mrc1990@163.com
 * @Date : Created in 9:34 2018/1/5
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(Double.parseDouble("5"));
        String s = "2*2*2*2*2*2*2";
        System.out.println(m(s));
    }

    private static int m(String s) {
        List<String> list = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        int len = s.length();
        int temp = 0;
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                continue;
            }
            if (temp != i) {
                list.add(s.substring(temp, i));
            }
            temp = i + 1;
            Character top = null;
            switch (c) {
                case '(':
                    stack.push(c);
                    break;
                case ')':
                    top = stack.pop();
                    while (top != '(') {
                        list.add(String.valueOf(top));
                        top = stack.pop();
                    }
                    break;
                case '+':
                case '-':
                    if (!stack.isEmpty()) {
                        top = stack.peek();
                        if (top == '+' || top == '-' || top == '*' || top == '/') {
                            list.add(String.valueOf(stack.pop()));
                        }
                    }
                    stack.push(c);
                    break;
                case '*':
                case '/':
                    if (!stack.isEmpty()) {
                        top = stack.peek();
                        if (top == '*' || top == '/') {
                            list.add(String.valueOf(stack.pop()));
                        }
                    }
                    stack.push(c);
                    break;
            }
        }
        if(temp != len){
            list.add(s.substring(temp, len));
        }
        while (!stack.isEmpty()) {
            list.add(String.valueOf(stack.pop()));
        }
        Stack<Integer> tempStack = new Stack<>();
        String item = null;
        for (int i = 0; i < list.size(); i++) {
            item = list.get(i);
            if (Character.isDigit(item.charAt(item.length() - 1))) {//是数字
                tempStack.push(Integer.parseInt(item));
            } else {
                int right = tempStack.pop();
                int left = tempStack.pop();
                Character c1 = item.charAt(0);
                switch (c1) {
                    case '+':
                        tempStack.push(left + right);
                        break;
                    case '-':
                        tempStack.push(left - right);
                        break;
                    case '*':
                        tempStack.push(left * right);
                        break;
                    case '/':
                        tempStack.push(left / right);
                        break;
                }
            }
        }
        return tempStack.pop();
    }
}
