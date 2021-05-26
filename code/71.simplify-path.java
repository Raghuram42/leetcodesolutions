class Solution {
    public String simplifyPath(String path) {
        String[] inp = path.split("/");
        ArrayDeque<String> stk = new ArrayDeque<String>();
        for(String s: inp){
            if(s.length() > 0){
                if(!s.equals(".")){
                    if(s.equals("..")){
                        if(!stk.isEmpty())
                        stk.pop();
                    }
                    else
                        stk.push(s);
                }
            }
        }
        
        StringBuilder str = new StringBuilder();
  
        solve(stk, str);
        // String res = str.toString();
        if(str.length() == 0)
            str.append("/");
        return str.toString();
        
    }
    
    public void solve(ArrayDeque<String> stk, StringBuilder str){
        if(!stk.isEmpty()){
            String curr = stk.pop();
            solve(stk, str);
            str.append("/");
            str.append(curr);
            
             
        }
       
    }
}