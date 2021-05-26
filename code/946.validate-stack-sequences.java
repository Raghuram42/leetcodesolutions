class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stk = new Stack<>();
        
        
        int i = 0;
        int j = 0;
        while(i<=pushed.length){
            
                while(!stk.isEmpty() && j< popped.length && stk.peek() == popped[j]){
                    j++;
                    stk.pop();
                }
            if(i<pushed.length)
            stk.push(pushed[i]);
            i++;
        }
        return stk.isEmpty();
    }
}