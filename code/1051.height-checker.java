class Solution {
    public int heightChecker(int[] heights) {
     
    int[] height2 = new int[heights.length];
        
        for(int i=0;i<heights.length;i++)
            height2[i] = heights[i];
        
        Arrays.sort(height2);
        int res = 0;
        for(int i=0;i<heights.length;i++)
        {
            if(height2[i] != heights[i])
                res++;
        }
        return res;
    }
}