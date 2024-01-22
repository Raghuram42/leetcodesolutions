class Solution {
    public int minOperations(int[] nums) {
        int[] map = new int[1000001];
        
        for(int num: nums)
            map[num]++;
        int ans = 0;
        for(int next: map){
            if(next == 1)
                return -1;
            ans += (next/3) + (next%3 != 0 ? 1:0);
        }
        return ans;
    }
}