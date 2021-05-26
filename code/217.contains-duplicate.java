class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hst = new HashSet<Integer>();
        for(int num: nums){
            if(hst.contains(num))
                return true;
            hst.add(num);
        }
        
        return false;
    }
}