package RecurSection6;
import java.util.*;

public class Combination {

    public static void main(String[] args) {
        Combination c = new Combination();
       // c.combination("ABC", 2);

        c.permutation("ABC");

    }

    public void permutation(String a) {
        // int[] arr = new int[len];
        List<Integer> temp = new ArrayList<>();
        // List<List<Integer>> result=new ArrayList<>();
        boolean[] track=new boolean[a.length()];
        track[0]=true;
        track[1]=true;
       track[2]=true;
        permut(temp, a,track);
    }

    public void combination(String a, int len) {
        // int[] arr = new int[len];
        List<Integer> temp = new ArrayList<>();
        // List<List<Integer>> result=new ArrayList<>();
        comb(temp, a, 0, len);

    }

    public void comb(List<Integer> temp, String a, int count, int len) {
        if (temp.size() == len) {

            for (int i = 0; i < temp.size(); i++) {
                System.out.print(a.charAt(temp.get(i)));
            }
            System.out.println();
            return;
        }

        for (int i = count; i < a.length(); i++) {
            temp.add(i);
            comb(temp, a, i + 1, len);
            temp.remove(temp.size() - 1);
        }

    }

    public void permut(List<Integer> temp, String a,boolean track[]) {

        if (temp.size() == a.length()) {
            for (int i = 0; i < temp.size(); i++) {
                System.out.print(a.charAt(temp.get(i)));
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < a.length(); i++) {
            if(track[i]) {
                temp.add(i);
                track[i] = false;
                permut(temp, a, track);
                temp.remove(temp.size() - 1);
                track[i] = true;
            }
            else continue;

        }

    }
}
