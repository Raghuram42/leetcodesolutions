class Solution {
    public int trap(int[] height) {
        int n = height.length;
        if(n == 0)
            return 0;
        int[] right = new int[height.length];
        
        int i = n-2;
        right[n-1] = height[n-1];
        while(i>=0)
            right[i] = Math.max(height[i--], right[i+2]);
        
        i = 1;
        int res = 0;
        int max = height[0];
        while(i<n){
            max = Math.max(height[i], max);
            res += Math.min(max, right[i])-height[i++];
        }
        
        return res;
    }
}