import java.lang.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hsp = new HashMap<>();
        int res[] = new int[2];
        for(int i=0;i<nums.length;i++)
        {
            int dif = target-nums[i];
            if(hsp.containsKey(dif))
            {
                res[0] = hsp.get(dif);
                res[1] = i;
            }
            hsp.put( nums[i],i);
        }
        return res;
        
    }
}
