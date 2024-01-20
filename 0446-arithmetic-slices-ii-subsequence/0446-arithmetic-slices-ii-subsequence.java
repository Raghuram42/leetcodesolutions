class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n= nums.length;
        HashMap[] map = new HashMap[n];
        for(int i=0;i<n;i++)
            map[i] = new HashMap<Long, Integer>();
        int ans = 0;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                long diff = nums[i]-0l-nums[j];
                int sum = 0;
                if(map[j].containsKey(diff))
                    sum = (int)map[j].get(diff);
                
                map[i].put(diff, (int)map[i].getOrDefault(diff, 0)+sum+1);
                ans += sum;
            }
        }
        
        return ans;
    }
}