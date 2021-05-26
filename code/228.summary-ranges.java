class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if(nums.length == 0)
            return res;
        
        for(int i=0;i<nums.length;i++){
            StringBuilder str = new StringBuilder();
            str.append(nums[i]);
            int curr = i;
            
            while(curr+1 < nums.length && nums[curr+1] == nums[curr]+1)
                curr++;
            
            if(curr == i)
                res.add(str.toString());
            else{
                str.append("->");
                str.append(nums[curr]);
                res.add(str.toString());
                i=curr;
            }
        }
        return res;
    }
}