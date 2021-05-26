class Solution {
    public int maxArea(int[] height) {
        int res = -1;
        for(int i=0;i<height.length;i++){
            for(int j=height.length-1;j>=0;j--){
               res = Math.max(Math.min(height[i], height[j]) * (j-i), res);
            }
        }
        
        return res;
    }
}