class Solution {
    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> hsm =  new HashMap<Integer, Integer>();
        
        int max = 0;
        for(int num: nums){
            if(hsm.containsKey(k-num) && hsm.get(k-num) > 0){
                hsm.put(k-num, hsm.get(k-num)-1);
                max++;
            }
            else
            hsm.put(num, hsm.getOrDefault(num, 0)+1);
        }
        return max;
    }
}