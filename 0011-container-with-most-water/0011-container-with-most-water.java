class Solution {
    public int maxArea(int[] height) {
        int ans = 0;
        
        int  l = 0;
        int r = height.length-1;
        
        while(l<r){
            ans = Math.max(Math.min(height[l], height[r])*(r-l), ans);
            
            if(height[l] < height[r])
                l++;
            else
                r--;
        }
        
        return ans;
    }
}