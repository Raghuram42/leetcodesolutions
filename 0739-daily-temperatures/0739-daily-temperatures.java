class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stk = new Stack<>();
        
        
        int n = temperatures.length;
        int i = n-1;
        int[] res = new int[n];
        while(i>=0){
            
            while(!stk.isEmpty() && temperatures[i] >= temperatures[stk.peek()])
                stk.pop();
            res[i] = stk.isEmpty()  ? 0 : stk.peek()-i;
            stk.push(i);
            i--;
            
        }
        
        return res;
    }
}