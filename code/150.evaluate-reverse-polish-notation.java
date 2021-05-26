class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        
        HashSet<String> hst = new HashSet<>();
        
        hst.add("*");
        hst.add("/");
        hst.add("-");
        hst.add("+");
        for(int i=0;i<tokens.length;i++){
            if(hst.contains(tokens[i])){
                int f = stk.pop();
                int s = stk.pop();
                int val = 1;
                if(tokens[i].equals("+"))
                    val = f+s;
                else if(tokens[i].equals("-"))
                    val = s-f;
                else if(tokens[i].equals("/"))
                    val = s/f;
                else 
                    val = f*s;
                // System.out.println(f+" "+s+" "+val +" "+stk);    
                stk.push(val);
            }else 
                stk.push(Integer.parseInt(tokens[i]));
        }
        
        return stk.peek();
        
    }
}