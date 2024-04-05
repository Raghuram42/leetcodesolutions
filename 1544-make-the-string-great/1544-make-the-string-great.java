class Solution {
    public String makeGood(String s) {
        Stack<Character> stk = new Stack<>();

        int i = 0;
        int n =s.length();
        // System.out.println(('S'-'s')+" "+('K'-'k'));
        while(i<n){
            if(stk.isEmpty())
                stk.push(s.charAt(i));
            else if((Character.toUpperCase(stk.peek()) == s.charAt(i) || Character.toUpperCase(s.charAt(i)) == stk.peek()) && Math.abs(stk.peek()-s.charAt(i)) == 32)
                stk.pop();
            else 
            stk.push(s.charAt(i));
            i++;
        }

    StringBuilder res = new StringBuilder();

    while(!stk.isEmpty())
        res.append(stk.pop());    
    return res.reverse().toString();
    }
}