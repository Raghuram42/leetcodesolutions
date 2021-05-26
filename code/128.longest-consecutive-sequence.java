class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hsm = new HashSet<Integer>();
        if(nums.length == 0)
            return 0;
        for(int num: nums)
            hsm.add(num);
        
        int c = 0;
        int max = -1;
        for(int num: nums){
            int curr = num;
            while(hsm.contains(curr)){
                curr--;
                c++;
            }
            while(hsm.contains(curr)){
                curr++;
                c++;
            }
            max = Math.max(max, c);
            c = 0;
        }
        
        return max;
    }
}