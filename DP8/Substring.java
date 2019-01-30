package DP8;
import java.util.Stack;

public class Substring {
    public void subStr(String str1,String str2) {
        int length1 = str1.length();
        int length2 = str2.length();
        int[][] arr = new int[length1 + 1][length2 + 1];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < length1 + 1; j++) {
                arr[i][j] = 0;
            }
        }
        int max=0;
        int maxpositionend=0;
        for (int i = 0; i < length1; i++) {
            for (int j = 0; j < length2; j++) {
                if (str1.charAt(j) == str2.charAt(i)) {
                    arr[i + 1][j + 1] = arr[i][j] + 1;
                    if( arr[i + 1][j + 1]>max) {
                        max = arr[i + 1][j + 1];
                        maxpositionend=j+1;
                    }
                } else {
                    arr[i + 1][i + 1] = 0;
                }
            }
        }
        Stack<Character> stack=new Stack<>();
        System.out.println("Max common substring: "+max);
        int p=1;
        for(int k=0;k<max;k++) {
            stack.push(str1.charAt(maxpositionend - p));
            p++;
        }
        while(!stack.isEmpty())
        {
            System.out.print(stack.pop());
        }
    }

    public static void main(String[] args) {
        Substring sub=new Substring();
        String str1="ABCDEF";
        String str2="GABCEF";
        sub.subStr(str1,str2);
    }
}
