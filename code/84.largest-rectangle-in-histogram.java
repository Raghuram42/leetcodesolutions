class Solution {
    public int largestRectangleArea(int[] heights) {
     if(heights.length == 0)
         return 0;
        
        int maxarea = 0;
        int minarea = Integer.MAX_VALUE;
//         for(int i=0;i<heights.length;i++){
//             minarea = heights[i];
            
//             maxarea = Math.max(maxarea, minarea);
//             for(int j =i+1;j<heights.length;j++){
//                 minarea = Math.min(minarea, heights[j]);
//                 maxarea = Math.max(maxarea, minarea*(j-i+1));
//             }
//             // if(max)
//         }
        
        Stack<Integer> stk = new Stack<Integer>();
        
        
        int i = 0;
        int n = heights.length;
        
        while(i<n){
            
            if(stk.isEmpty() || heights[stk.peek()] <= heights[i])
                stk.push(i++);
            else{
                int tpind = stk.peek();
                stk.pop();
                maxarea = Math.max(heights[tpind]*(stk.isEmpty() ? i : i-stk.peek()-1), maxarea);
                
            }
        }
        
        while(!stk.isEmpty()){
                
                int tpind = stk.peek();
                stk.pop();
                maxarea = Math.max(heights[tpind]*(stk.isEmpty() ? i : i-stk.peek()-1), maxarea);
            
        }
        
        return maxarea;
    }
}