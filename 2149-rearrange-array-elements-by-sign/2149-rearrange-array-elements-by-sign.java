class Solution {
    public int[] rearrangeArray(int[] nums) {
        int p = 0;
        int neg = 0;
        int n = nums.length;
        int i = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        while(i<n){
            if(nums[i] > 0)
                q1.add(nums[i]);
            else 
                q2.add(nums[i]);
            i++;
        }
        
        i = 0;
        
        while(i<n){
            nums[i++] = q1.poll();
            nums[i++] = q2.poll();
        }
        
        return nums;
        
    }
}