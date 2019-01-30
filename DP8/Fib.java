package DP8;

import java.util.HashMap;

public class Fib {

    public int fibb(int element)
    {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,0);
        map.put(1,1);
        if(element<=1)
            return element;
        int result=fibb(element-1)+fibb(element-2);
        if(!map.containsKey(element))
        map.put(element,result);
        return result;
    }


    public int kadanesubarraysum(int[] arr)
    {
        int sum=0;
        int max=Integer.MIN_VALUE;
        int startindex=0;int endindex=0;int index=0;

        for(int i=0;i<arr.length;i++)
        {
            sum=sum+arr[i];
            if(sum>max) {
                max = sum;
                startindex=index;
                endindex=i;
            }
            if(sum<0)
            {
                sum=0;
                index=i+1;
            }
        }
        System.out.println("Index"+ " "+startindex +" "+endindex);
        return max;
    }

public int  min(int a,int b)
{
    if(a<b)
    {
       return a;
    }
    else
        return b;
}
    public void shortestPath(int[][] arr,int row,int col)
    {
        int j=0;
        int[][]arr2=new int[row][col];
        int i=0;
           while(j<col) {
               if(j==0)
               {
                   arr2[i][i]=arr[i][i];
               }
               else {
                   arr2[i][j] = arr2[i][j-1] + arr[i][j];
               }
                   j++;
           }
           j=1;
           int k=0;
            while(j<row) {
                arr2[j][k] = arr2[j-1][k] + arr[j][k];
                j++;
            }

            for(i=1;i<row;i++)
            {
                for(j=1;j<col;j++)
                {
                    arr2[i][j]=arr[i][j]+min(arr2[i-1][j-1],min(arr2[i][j-1],arr2[i-1][j]));
                }
            }
            System.out.println("Shortest distance: "+arr2[2][2]);
    }


        public static void main(String[] args) {
        Fib f=new Fib();
        int res=f.fibb(9);
      //  System.out.println(res);
        int a[]=new int[]{1,-2,4,-1,-2,1,5,-3};
     //   int max=f.kadanesubarraysum(a);
     //   System.out.println(max);

        int[][] arr={{1,3,2},{8,4,14},{9,11,10}};
        f.shortestPath(arr,3,3);
        }


    }

