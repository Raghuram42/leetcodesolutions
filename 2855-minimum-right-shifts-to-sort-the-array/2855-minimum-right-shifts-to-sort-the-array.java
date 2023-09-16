class Solution {
    public int minimumRightShifts(List<Integer> nums) {
        int m = 0;
        
        int i = 0;
        int n = nums.size();
        int ind = n;
        
        while(i<n-1 && nums.get(i) <= nums.get(i+1))
            i++;
        
        if(i == n-1)
            return 0;
        // System.out.println("i: "+i);
        if(i<n-1 && nums.get(i) > nums.get(i+1)){
            int j = i+1;
            
            while(j<n-1 && nums.get(j) < nums.get(j+1))
                j++;
            
            if(j == n-1)
                return nums.get(0) >= nums.get(n-1) ? n-i-1 : -1;
        }
     return -1;   
    }
}