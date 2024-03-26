class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int end = 0;
        int st = 0;
        int n = nums.length;
        
        long ans = 0;
        long sum = 0;
        int count = 0;
        while(end<n){
            // System.out.println(end+" "+st+" "+k+" "+map+" "+count);
            if(end-st+1 <= k){
                sum += nums[end];
                map.put(nums[end], map.getOrDefault(nums[end], 0)+1);
                count++;
            }else if(end-st+1 > k){
                
                    map.put(nums[st], map.getOrDefault(nums[st], 0)-1);
                    count--;
                    if(map.get(nums[st]) == 0)
                        map.remove(nums[st]);                    
                    
                  sum += nums[end]-nums[st];
                  map.put(nums[end], map.getOrDefault(nums[end], 0)+1);
                  count++;
                  st++;
            }
                if(map.size() == count && count == k)
                    ans = Math.max(sum, ans);   
            end++;
        }
        
        
        return ans;
    }
}


// nums = [1,5,4,2,9,9,9], k = 3
    
    // map =>