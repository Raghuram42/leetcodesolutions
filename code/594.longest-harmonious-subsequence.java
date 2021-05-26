class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> hsm = new HashMap<>();
        
        for(int n:nums)
            hsm.put(n, hsm.getOrDefault(n, 0)+1);
        int max = 0;
        for(int p : hsm.keySet()){
            int val = hsm.get(p);
            if(hsm.containsKey(p+1))
                max = Math.max(max, val+ hsm.get(p+1));
        }
        
        return max;
    }
}