class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stk = new Stack<Integer>();
        int n = temperatures.length;
        int[] res = new int[n];
        
        int i = n-1;
        
        while(i>=0){
            
            while(!stk.isEmpty() && temperatures[stk.peek()] <= temperatures[i])
                stk.pop();
            
            
            res[i] = stk.isEmpty() ? 0 : stk.peek()-i;
            
            stk.push(i);
            i--;
            
        }
        return res;
    }
}