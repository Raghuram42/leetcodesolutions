class FindSumPairs {
    int[] nums1;
    int[] nums2;
    HashMap<Integer, Integer> hsm ;
    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        
        hsm = new HashMap<Integer, Integer>();
        for(int i=0;i<nums2.length;i++){
                hsm.put(nums2[i], hsm.getOrDefault(nums2[i], 0)+1);
        }
        
    }
    
    public void add(int index, int val) {
        int initialval = nums2[index];
        nums2[index] += val;
        hsm.put(initialval, hsm.get(initialval)-1);
        hsm.put(nums2[index], hsm.getOrDefault(nums2[index], 0)+1);
    }
    
    public int count(int tot) {
        int res = 0;
        
        
        for(int i=0;i<nums1.length;i++)
        {
            if(hsm.containsKey(tot-nums1[i]))
                res += hsm.get(tot-nums1[i]);
        }
        
        return res;
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */