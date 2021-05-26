class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hsm = new HashMap<Integer, Integer>();
        if(nums1.length > nums2.length)
            return intersect(nums2,nums1);
        
        for(int num: nums1)
            hsm.put(num, hsm.getOrDefault(num,0)+1);
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        for(int num:nums2){
            if(hsm.containsKey(num) && hsm.get(num) > 0){
                hsm.put(num, hsm.get(num)-1);
                ans.add(num);
            }
        }
        return ans.stream().mapToInt(i->i).toArray();
        
    }
}