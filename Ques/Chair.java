package Ques;

import java.util.*;

public class Chair {

    public class Interval{
        int start;
        int end;
        Interval(int start,int end)
        {
            this.start=start;
            this.end=end;
        }
    }
    public int chairCount(int[] in,int[] out)
    {
        List<Interval> list=new ArrayList<>();
        for(int i=0;i<in.length;i++)
        {
            Interval interval=new Interval(in[i],out[i]);
            list.add(interval);
        }
        Collections.sort(list, new Comparator<Interval>() {
                    @Override
                    public int compare(Interval o1, Interval o2) {
                        return o1.start-o2.start;
                    }
                });
        Queue<Integer> queue = new PriorityQueue<>();
        for(Interval l:list) {
            if (!queue.isEmpty()) {
                int min = queue.peek();
                if (l.start>=min)
                {
                    queue.remove();
                }
            }
            queue.add(l.end);
        }
        return queue.size();
    }




    public static void main(String[] args) {
        int[] in=new int[]{1,2,6,5,3};
        int[] out=new int[]{5,5,7,6,8};
        Chair chair=new Chair();
        System.out.println(chair.chairCount(in,out));
    }
}
