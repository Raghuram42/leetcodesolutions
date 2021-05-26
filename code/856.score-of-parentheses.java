class Solution {
    public int scoreOfParentheses(String S) {
        Deque<Integer> stk  = new ArrayDeque<>();
        stk.push(0);
        for(int i =0;i<S.length();i++)
        {
            if(S.charAt(i) == '(')
                stk.push(0);
            else{
                int f =stk.pop();
                int s =stk.pop();
                stk.push(s+Math.max(f*2,1));
            }
        }
        
        return stk.pop();
    }
}