class Solution {
    public int trap(int[] height) {
        int i = 1;
        int n = height.length;
        int[] left = new int[n];
        left[0] = height[0];
        int v = left[0];
        while(i<n){
            left[i] = v;
            v = Math.max(height[i], v);
            i++;                
        }
        
        int ans = 0;
        
        i = n-1;
        int h = height[n-1];
        while(i>=0){
            ans += Math.max(0, Math.min(left[i], h)-height[i]);
            // System.out.println(i+" "+height[i]+" lef "+left[i]+" r "+h+" ans "+ans);
                        h = Math.max(h, height[i]);

            i--;
        }
        
        return ans;
    }
}