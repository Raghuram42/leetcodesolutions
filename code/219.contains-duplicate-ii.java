class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> hst = new HashSet<Integer>();
        int p = 0;
        for(int num: nums){
           // System.out.println(p+" "+num+" "+hst);
            if(hst.contains(num))
                return true;
            hst.add(num);
            if(p>=k){
                hst.remove(nums[p-k]);
            }
             p++;
        }
        return false;
    }
}