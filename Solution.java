import java.util.*;
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            for(Integer j : map.keySet())
            {
                if(j==(nums[i])){
                    int v=map.get(j);
                    if((i-v)<=k)
                        return true;
                }
            }
            map.put(nums[i],i);
        }
        return false;
    }




    public static void main(String[] args) {
        Solution s=new Solution();
       int[] nums = new int[]{1,2,3,1};
       int k = 3;
       s.containsNearbyDuplicate(nums,k);

    }
}

