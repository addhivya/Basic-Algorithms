package DP8;

public class Subsequence {

   public void  subsequence(String str1,String str2) {
       int column = str1.length() + 1;
       int row = str2.length() + 1;
       int arr[][] = new int[row][column];
       int j = 0;
       int max = 0;
       int maxstart = 0;
       int maxend = 0;
       while (j < column) {
           arr[0][j] = 0;
           j++;
       }
       int i = 0;
       while (i < row) {
           arr[i][0] = 0;
           i++;
       }
       for (i = 0; i < column-1; i++) {
           for (j = 0; j < row-1; j++) {
               if (str2.charAt(i) == str1.charAt(j)) {
                   arr[i + 1][j + 1] = 1 + Math.max(arr[i][j + 1], arr[i + 1][j]);
                   if (max < arr[i + 1][j + 1]) {
                       max = arr[i + 1][j + 1];
                       System.out.println(str2.charAt(i));
                   }
               } else {
                   arr[i + 1][j + 1] = Math.max(arr[i][j + 1], arr[i + 1][j]);
               }
           }
       }
       System.out.println("Max Subseq: "+max);
   }


   public void increasingSubSeq(int[] arr)
   {
    int[] arr2=new int[arr.length];
    for(int i=0;i<arr.length;i++)
    {
        arr2[i]=1;
    }
    for(int i=1;i<arr.length;i++)
    {
        for(int j=0;j<i;j++)
        {
            if(arr[j]<arr[i])
            {
                if((arr2[j]+1)>arr2[i]) {
                    arr2[i] = arr2[j] + 1;
                }
            }
        }
    }
    int max=0;
    for(int i=0;i<arr2.length;i++)
    {
        if(arr2[i]>max)
        {
            max=arr2[i];
        }
    }
      System.out.println("Max Increasing subseq: "+max);
   }


    public static void main(String[] args) {
        Subsequence sequence =new Subsequence();
     /*   String str1="abcdgh";
        String str2="aedfhr";
        sequence.subsequence(str1,str2);*/
     int[] arr=new int[]{7,2,9,3,-1,4,5,11};
     sequence.increasingSubSeq(arr);

    }
}
