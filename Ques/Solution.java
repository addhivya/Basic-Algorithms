package Ques;

//Find the store which is closes to the house. If 2 stores are equal distance, the one with lower value will be the output.
//return an array of size house with each value representing the store nearer to it.

import java.util.Set;
import java.util.TreeSet;

public class Solution {

    public int[] solution(int[] stores,int[] houses)
    {
        //Arrays.sort(stores);

        int [] result = new int[houses.length];

        Set<Integer> set = new TreeSet<>();

        for(int store : stores) {
            set.add(store);
        }

        for(int i=0; i< houses.length; i++) {
            if(set.contains(houses[i])) {
                result[i] = houses[i];
            } else {
                int ceil = ((TreeSet<Integer>) set).ceiling(houses[i]);
                int floor = ((TreeSet<Integer>) set).floor(houses[i]);

                result[i] = Math.abs(houses[i]-ceil) < Math.abs(houses[i]-floor) ? ceil : floor;
            }
        }
        return result;
    }

    public int getNearest(int[] arr, int n, int closestDistance, int closestValue, int start, int end) {
        if(arr.length == 0) {
            return -1;
        }
        if(end < start) {
            return closestValue;
        }
        int mid = (start + end) /2;
        if(arr[mid] == n) {
            return arr[mid];
        }
        int distance = Math.abs(arr[mid]-n);
        if((closestDistance > distance) ||(closestDistance == distance && closestValue>arr[mid])) {
            closestDistance = distance;
            closestValue = arr[mid];
        }

        if(arr[mid] > n) {
            return getNearest(arr, n, closestDistance, closestValue, start, mid -1);
        } else {
            return getNearest(arr, n, closestDistance, closestValue, mid+1, end);
        }
    }


    public static void main(String[] args) {
        int[] stores={2,5,0,10,100,120,40,34,23};
        int[] houses={22,1,18,98,56, 120};
        Solution s=new Solution();
        int[] res=s.solution(stores,houses);
        for(int i=0;i<res.length;i++)
        {
            System.out.println(res[i]);
        }
    }
}
