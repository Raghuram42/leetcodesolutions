class Solution {
    public int maximalRectangle(char[][] matrix) {
        int res = 0;
        int n = matrix.length;
        if(n == 0)
            return 0;
        int m = matrix[0].length;
        int[] curr = new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++)
                curr[j] = matrix[i][j] == '0' ? 0 : curr[j]+1;
            
            res = Math.max(res, maxAreaHist(curr));
        }
        return res;
    }
    
    
    public int maxAreaHist(int[] curr){
        
        Stack<Integer> stk = new Stack<>();
        
        int i = 0;
        int n = curr.length;
        int ans = 0;
        while( i < n){
            if(stk.isEmpty() || curr[stk.peek()] <= curr[i]){
                stk.push(i);
                i++;
            }else{
                int ind = stk.pop();
                ans = Math.max(ans, curr[ind] * (stk.isEmpty() ? i : i-stk.peek()-1));
            }
            
        }
        
        while(!stk.isEmpty()){
            int ind = stk.pop();
                ans = Math.max(ans, curr[ind] * (stk.isEmpty() ? i : i-stk.peek()-1));
        }
        
        return ans;
        
    }
}