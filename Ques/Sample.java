package Ques;
//Given an array of values, each value in the array is the parent and index is the child. Given a count value, return an array
//representing the node each index would have reached.
import java.util.*;
public class Sample {

    public int[] solution(int D, int[]  A) {

        // {-1, 0, 4, 2, 1}
        // {-1, -1, 0, 1, -1}
        // D = 3
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<A.length;i++) {
            map.put(i,A[i]);
        }

        int[] result = new int[A.length];
        for(int i=0; i<A.length; i++) {
            int current = map.get(i);
            int count = 1;
            while(current != -1 && count<D) {
                current = map.get(current);
                count++;
            }
            result[i] = current;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] A={-1, 0, 4, 2, 1};
        Sample s=new Sample();
        int[] res =s.solution(3,A);
        for(int i: res) {
            System.out.println(i);
        }
    }
}
