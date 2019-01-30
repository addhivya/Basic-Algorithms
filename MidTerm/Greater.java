package MidTerm;

import java.util.Stack;

public class Greater {

    public int[] nextGreater(int[] arr) {
        int result[] = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        int length = arr.length;
        if (length < 1) {
            return result;
        }
        if (length == 1) {
            result[length - 1] = Integer.MIN_VALUE;
            return result;
        }
        int i = length - 1;
        result[i] = Integer.MIN_VALUE;
        stack.push(arr[i]);
        for (i = length - 2; i >= 0; i--) {
            int top = stack.peek();
            if (top > arr[i]) {
                result[i] = top;
                stack.push(arr[i]);
            } else {
                while (!stack.isEmpty()) {
                    if (stack.peek() < arr[i]) {
                        stack.pop();
                    } else {
                        result[i] = stack.peek();
                        stack.push(arr[i]);
                        break;
                    }
                }
                if (stack.isEmpty()) {
                    result[i] = Integer.MIN_VALUE;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Greater greater = new Greater();
        int list[] = new int[4];
        list[0] = 6;
        list[1] = 8;
        list[2] = 2;
        list[3] = 34;
        int[] result = greater.nextGreater(list);
        for (int i = 0; i < result.length; i++) {
            System.out.println(list[i] + " ---> " + result[i]);
        }
    }
}
