package DP8;

public class Bittonic {

    public void bittonicSeq(int[] arr)
    {
     int[] arr2=new int[arr.length];
     for(int i=0;i<arr2.length;i++)
     {
         arr2[i]=1;
     }
     for(int i=1;i<arr.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(arr[j]<arr[i])
                {
                    if((arr2[j]+1)>arr2[i])
                    {
                            arr2[i]=arr2[j]+1;
                    }
                }
            }
        }
        int[] rev=new int[arr.length];
     int len=arr.length;
     for(int i=0;i<arr.length;i++)
     {
         rev[len-1]=arr[i];
         len--;
     }
      int[] rev2=new int[rev.length];
        for(int i=0;i<arr2.length;i++)
        {
            rev2[i]=1;
        }
        for(int i=1;i<rev.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(rev[j]<rev[i])
                {
                    if((rev2[j]+1)>rev2[i])
                    {
                        rev2[i]=rev2[j]+1;
                    }
                }
            }
        }


        int[] rev3=new int[rev2.length];
        int length=rev2.length;
        for(int i=0;i<arr.length;i++)
        {
            rev3[length-1]=rev2[i];
            length--;
        }

        int max=0;
        for(int i=0;i<arr2.length;i++)
        {
            if(arr2[i]+rev3[i]>max)
        {
            max=arr2[i]+rev3[i];
        }
        }
        for(int i=0;i<rev.length;i++)
        {
            System.out.print(arr2[i]);
        }
        System.out.println(max-1);
    }

    public static void main(String[] args) {
        Bittonic bit=new Bittonic();
        int arr[]=new int[]{7,-1,3,8,2,11,6,-2,5};
        bit.bittonicSeq(arr);

    }
}
