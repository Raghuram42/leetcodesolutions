class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Integer> stk = new ArrayDeque<Integer>();
        
        for(int i =0;i<num.length();i++){
            
            
            while(!stk.isEmpty() && k > 0 && stk.peek() > num.charAt(i)-'0'){
                k--;
                stk.pop();
            }
            
            stk.push(num.charAt(i)-'0');
        }
        while((k > 0) && !stk.isEmpty()){
            stk.pop();
            k--;
        }
        StringBuilder res = new StringBuilder();
        boolean hasz=  true;
        while(!stk.isEmpty()){
            int c = stk.pop();
            res.append(c);
        }
        
        int i=res.length()-1;
        // System.out.println(res.toString());
        while(i>=0){
            if(res.charAt(i) == '0')
                res.deleteCharAt(i);
            else break;
            i--;
        }
        // else break;

        
        
        if(res.length() == 0)
            return "0";
                return res.reverse().toString();
    }
    
    // public void reverse(StringBuilder str){}
}