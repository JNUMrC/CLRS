import java.util.Arrays;
import java.util.LinkedList;

/**
 * 暴力算法解决推理题
 * @Author : jnu_mrc jnu_mrc1990@163.com
 * @Date : Created in 15:23 2018/3/2
 */
public class Explicit {
    public static void main(String[] args) {
        int[] arr = new int[11];
        int ANSWER_START = 1,ANSWER_END = 4;
        for (arr[1] = ANSWER_START; arr[1] <= ANSWER_END; arr[1]++) {
            for (arr[2] = ANSWER_START; arr[2] <= ANSWER_END; arr[2]++) {
                for (arr[3] = ANSWER_START; arr[3] <= ANSWER_END; arr[3]++) {
                    for (arr[4] = ANSWER_START; arr[4] <= ANSWER_END; arr[4]++) {
                        for (arr[5] = ANSWER_START; arr[5] <= ANSWER_END; arr[5]++) {
                            for (arr[6] = ANSWER_START; arr[6] <= ANSWER_END; arr[6]++) {
                                for (arr[7] = ANSWER_START; arr[7] <= ANSWER_END; arr[7]++) {
                                    for (arr[8] = ANSWER_START; arr[8] <= ANSWER_END; arr[8]++) {
                                        for (arr[9] = ANSWER_START; arr[9] <= ANSWER_END; arr[9]++) {
                                            for (arr[10] = ANSWER_START; arr[10] <= ANSWER_END; arr[10]++) {
                                                if (check(arr)) {
                                                    //输出结果
                                                    printAnswer(arr);
//                                                    break;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static LinkedList<Question> questions = new LinkedList<>();

    static {
        //1
        questions.add((int[] arr) -> {
            return true;
        });
        //2
        questions.add((int[] arr) -> {
            switch (arr[2]) {
                case 1:
                    return arr[5] == 3;
                case 2:
                    return arr[5] == 4;
                case 3:
                    return arr[5] == 1;
                case 4:
                    return arr[5] == 2;
            }
            return false;
        });
        //3
        questions.add((int[] arr) -> {
            switch (arr[3]) {
                case 1:
                    return arr[3] != arr[6] && arr[6] == arr[2] && arr[6] == arr[4];
                case 2:
                    return arr[3] != arr[6] && arr[3] == arr[2] && arr[3] == arr[4];
                case 3:
                    return arr[2] != arr[4] && arr[4] == arr[3] && arr[4] == arr[6];
                case 4:
                    return arr[2] != arr[4] && arr[2] == arr[3] && arr[2] == arr[6];
            }
            return false;
        });
        //4
        questions.add((int[] arr) -> {
            switch (arr[4]) {
                case 1:
                    return arr[1] == arr[5];
                case 2:
                    return arr[2] == arr[7];
                case 3:
                    return arr[1] == arr[9];
                case 4:
                    return arr[6] == arr[10];
            }
            return false;
        });
        //5
        questions.add((int[] arr) -> {
            switch (arr[5]) {
                case 1:
                    return arr[8] == 1;
                case 2:
                    return arr[4] == 2;
                case 3:
                    return arr[9] == 3;
                case 4:
                    return arr[7] == 4;
            }
            return false;
        });
        //6
        questions.add((int[] arr) -> {
            switch (arr[6]) {
                case 1:
                    return arr[8] == arr[2] && arr[8] == arr[4];
                case 2:
                    return arr[8] == arr[1] && arr[8] == arr[6];
                case 3:
                    return arr[8] == arr[3] && arr[8] == arr[10];
                case 4:
                    return arr[8] == arr[5] && arr[8] == arr[9];
            }
            return false;
        });
        //7
        questions.add((int[] arr) -> {
            int[] t = {0, 0, 0, 0, 0};
            for (int i = 0; i < arr.length; i++) {
                t[arr[i]]++;
            }
            int min = 1, n = t[1];
            for (int i = 2; i < t.length; i++) {
                if (t[i] < n) {
                    min = i;
                    n = t[i];
                }
            }
            switch (arr[7]) {
                case 1:
                    return min == 3;
                case 2:
                    return min == 2;
                case 3:
                    return min == 1;
                case 4:
                    return min == 4;
            }
            return false;
        });
        //8
        questions.add((int[] arr) -> {
            switch (arr[8]) {
                case 1:
                    return notClose(arr[7], arr[1]);
                case 2:
                    return notClose(arr[5], arr[1]);
                case 3:
                    return notClose(arr[2], arr[1]);
                case 4:
                    return notClose(arr[10], arr[1]);
            }
            return false;
        });
        //9
        questions.add((int[] arr) -> {
            boolean f = arr[6] == arr[1];
            switch (arr[9]) {
                case 1:
                    return arr[6] == arr[5] ^ f;
                case 2:
                    return arr[10] == arr[5] ^ f;
                case 3:
                    return arr[2] == arr[5] ^ f;
                case 4:
                    return arr[9] == arr[5] ^ f;
            }
            return false;
        });
        //10
        questions.add((int[] arr) -> {
            int[] t = {0, 0, 0, 0, 0};
            for (int i = 0; i < arr.length; i++) {
                t[arr[i]]++;
            }
            int minNum = t[1], maxNum = t[1];
            for (int i = 2; i < t.length; i++) {
                if (t[i] < minNum) {
                    minNum = t[i];
                }
                if (t[i] > maxNum) {
                    maxNum = t[i];
                }
            }
            switch (arr[10]) {
                case 1:
                    return maxNum - minNum == 3;
                case 2:
                    return maxNum - minNum == 2;
                case 3:
                    return maxNum - minNum == 4;
                case 4:
                    return maxNum - minNum == 1;
            }
            return false;
        });
    }

    private static boolean notClose(int a, int b) {
        switch (a) {
            case 1:
                return b != 2;
            case 2:
                return b != 3 && b != 1;
            case 3:
                return b != 4 && b != 2;
            case 4:
                return b != 3;
        }
        return false;
    }

    private static void printAnswer(int[] arr) {
        char[] answers = new char[10];
        for (int i = 1; i < arr.length; i++) {
            switch (arr[i]) {
                case 1:
                    answers[i - 1] = 'A';
                    break;
                case 2:
                    answers[i - 1] = 'B';
                    break;
                case 3:
                    answers[i - 1] = 'C';
                    break;
                case 4:
                    answers[i - 1] = 'D';
                    break;
            }
        }
        System.out.println(Arrays.toString(answers));
    }

    private static boolean check(int[] arr) {
        LinkedList<Question> list = questions;
        int pass = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).test(arr)) {
                pass++;
            }
        }
        return pass == 10;
    }

    private interface Question {
        boolean test(int[] arr);
    }
}
