package Ques;

public class Jumpend {

    public int jump(int[] a)
    {
        int count = 0;
        for(int i=0;i<a.length;i++) {
            int currentIndex = i;
            boolean seeLarger = true;
            while(currentIndex!=-1 && currentIndex!=a.length-1) {
                currentIndex = seeLarger ?  nextLarger(currentIndex, a) : nextSmallest(currentIndex, a);
                seeLarger = !seeLarger;
            }
            if(currentIndex == a.length -1) {
                count++;
            }
        }

        return count;
    }

    public int nextLarger(int start,int[] a)
    {
        int currentElement = a[start];
        int min=Integer.MAX_VALUE;
        int minIndex = -1;
        for(int j=start+1;j<=a.length-1;j++) {
            if (a[j] > currentElement && a[j] < min) {
                min = a[j];
                minIndex = j;
            }
        }
        return minIndex;
    }


    public int nextSmallest(int start, int[] a)
    {
        int currentElement = a[start];
        int min=Integer.MIN_VALUE;
        int minIndex = -1;
        for(int j=start+1;j<=a.length-1;j++) {
            if (a[j] < currentElement && a[j] > min) {
                min = a[j];
                minIndex = j;
            }
        }
        return minIndex;
    }

    public static void main(String[] args) {
        int[] a=new int[]{10,11,14,11,10};
        Jumpend j=new Jumpend();
        System.out.println(j.jump(a));


    }
}
