class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        
        int i = 0;
        int n = s.length();
        
        while(i<n){
            if(stk.isEmpty() || s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                stk.push(s.charAt(i));
            }else{
                if((s.charAt(i) == ')' && stk.peek() == '(')  || (s.charAt(i) == '}' && stk.peek() == '{') || (s.charAt(i) == ']' && stk.peek() == '['))
                    stk.pop();
                else
                    return false;
            }
            
            i++;
        }
        
        return stk.size() == 0;
    }
}