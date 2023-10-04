class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stk = new Stack<>();
        
        int i = 0;
        int n = heights.length;
        int ans = 0;
        while(i<n){
            while(!stk.isEmpty() && heights[stk.peek()] > heights[i])
            {
                ans = Math.max(ans, heights[stk.pop()]*(stk.isEmpty() ? i : (i-stk.peek()-1)));
            }
            
            stk.push(i);
            i++;
        }
        
        while(stk.size() > 0)
                ans = Math.max(ans, heights[stk.pop()]*(stk.isEmpty() ? i : (i-stk.peek()-1)));
        
        // ans = Math.max(ans, (stk.size())*heights[stk.pop()]);
        
        return ans;
    }
}