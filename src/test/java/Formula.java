import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 计算公式类,配置示例：$1+($2-0.5*$3)*$4-$5
 * '$'符号代表是非常数，具体值可能根据配置，也可能是取玩家某数据值
 * 操作符两侧允许添加空格。请使用英文输入法。
 * @Author : jnu_mrc jnu_mrc1990@163.com
 * @Date : Created in 10:02 2018/3/2
 */
public class Formula {
    // test
    public static void main(String[] args) {
        String config = "$1 + ($2 - 0.5*$3)*$4-$5";
        Formula formula = new Formula(config);
        System.out.println(formula.getScore(null));
    }

    /** 存放操作数以及操作的集合 */
    private List<CalculateElement> l = new ArrayList<>();

    /** 根据配置完成初始化 公式字符串中操作符两侧允许添加空格，允许使用小数点 */
    public Formula(String config) {
        // config.replaceAll(" ", "");
        List<String> list = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        int len = config.length();
        int temp = 0;
        for (int i = 0; i < len; i++) {
            char c = config.charAt(i);
            if (Character.isDigit(c) || c == '.') {
                continue;
            }
            if (temp != i) {
                list.add(config.substring(temp, i));
            }
            temp = i + 1;
            Character top;
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
                    while (!stack.isEmpty()) {
                        top = stack.peek();
                        if (top == '+' || top == '-' || top == '*' || top == '/') {
                            list.add(String.valueOf(stack.pop()));
                        } else {
                            break;
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
                case '$':
                    break;
            }
        }
        if (temp != len) {
            list.add(config.substring(temp, len));
        }
        while (!stack.isEmpty()) {
            list.add(String.valueOf(stack.pop()));
        }
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if (!Character.isDigit(str.charAt(str.length() - 1))) {
                l.add(getOperator(str.charAt(0)));
            } else if (Character.isDigit(str.charAt(0))) {
                l.add(new Const(str));
            } else {
                l.add(new NonConst(Integer.parseInt(str.substring(1))));
            }
        }
    }

    /** 根据操作符号获取操作符枚举对象 */
    private Operator getOperator(char c) {
        switch (c) {
            case '+':
                return Operator.ADD;
            case '-':
                return Operator.SUBTRACT;
            case '*':
                return Operator.MULTIPLY;
            case '/':
                return Operator.DIVIDE;
        }
        return null;
    }

    /** 开放给外部的接口，获取该种类型的评分*/
    public int getScore(Player player) {
        List<CalculateElement> l = this.l;
        // 用于存放结果和临时值的辅助栈
        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < l.size(); i++) {
            CalculateElement a = l.get(i);
            a.operate(player, l, stack);
        }
        return stack.pop().intValue();
    }

    /**
     * 常量操作数类
     */
    private class Const implements CalculateElement {
        private double num;

        public Const(String s) {
            num = Double.parseDouble(s);
        }

        @Override
        public void operate(Player player, List<CalculateElement> l, Stack<Double> stack) {
            stack.push(num);
        }

        @Override
        public String toString() {
            return num + "";
        }
    }

    /** 算术表达式的组成元素接口，主要实现为操作和操作数（常量和非常量）*/
    private interface CalculateElement {
        void operate(Player player, List<CalculateElement> l, Stack<Double> stack);
    }

    /**
     * 操作符类
     */
    private enum Operator implements CalculateElement {
        ADD, SUBTRACT, MULTIPLY, DIVIDE;

        @Override
        public void operate(Player player, List<CalculateElement> l, Stack<Double> stack) {
            double right = stack.pop();
            double left = stack.pop();
            switch (this) {
                case ADD:
                    stack.push(left + right);
                    break;
                case SUBTRACT:
                    stack.push(left - right);
                    break;
                case MULTIPLY:
                    stack.push(left * right);
                    break;
                case DIVIDE:
                    stack.push(left / right);
                    break;
            }
        }

        @Override
        public String toString() {
            return this.name();
        }
    }

    /**
     * 非常量操作数类
     */
    private class NonConst implements CalculateElement {
        private int key;

        public NonConst(int key) {
            this.key = key;
        }

        @Override
        public void operate(Player player, List<CalculateElement> l, Stack<Double> stack) {
            stack.push(getValue(player));
        }

        private double getValue(Player player) {

            switch (key) {
                case 1: // 已上阵伙伴数
                    return 1;
                case 2: // 当前可上阵人数
                    return 2;
                case 3: //
                {
                    return 3;
                }
                default:
                    return 0;
            }
        }

        @Override
        public String toString() {
            return getValue(null) + "";
        }
    }
}



