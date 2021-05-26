class Solution {
    public boolean isValid(String s) {
        if(s.length() == 0)
            return true;
        if(s.length()%2 == 1)
            return false;
       Stack<Character> stk = new Stack<Character>();
        stk.push(s.charAt(0));
        int p = 1;
        
        while(p < s.length()){
            
            if(s.charAt(p) == '(' || s.charAt(p) == '[' || s.charAt(p) == '{')
                stk.push(s.charAt(p));
            else
            if(!stk.isEmpty() && (s.charAt(p) == ')' && stk.peek() == '(') || (s.charAt(p) == '}' && stk.peek() == '{') || (s.charAt(p) == ']' && stk.peek() == '[')){
                stk.pop();
            }          
            else
                return false;
            p++;
        }
       return stk.isEmpty();
    }
}