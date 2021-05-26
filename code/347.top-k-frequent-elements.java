class Solution {
    
    public int[] topKFrequent(int[] nums, int k) {
    HashMap<Integer, Integer> hsm = new HashMap<>();
        
        for(int i=0;i<nums.length;i++)
            hsm.put(nums[i], hsm.getOrDefault(nums[i], 0)+1);
        
        PriorityQueue<Integer> Pre = new PriorityQueue<Integer>((b,a) -> hsm.get(a) - hsm.get(b));
        
        for(Integer in : hsm.keySet())
            Pre.offer(in);
        
        int[] res = new int[k];
        for(int i=0;i<k;i++)
            res[i] = Pre.poll();
        return res;
        
}
}