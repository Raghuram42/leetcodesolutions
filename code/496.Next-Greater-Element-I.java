class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stk = new Stack<>();
        int[] map = new int[10001];
        int n = nums2.length;
        for(int i=n-1;i>=0;i--){
            while(!stk.isEmpty() && nums2[stk.peek()] <= nums2[i])
                stk.pop();
            
            map[nums2[i]] = stk.isEmpty() ? -1 : nums2[stk.peek()];
            stk.push(i);
        }
        
        n = nums1.length;
        int[] res = new int[n];
        int i = 0;
        for(int next: nums1)
            res[i++] = map[next] ;
        
        return res;
    }
}
