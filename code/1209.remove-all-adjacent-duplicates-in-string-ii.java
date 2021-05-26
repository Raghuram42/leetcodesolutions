class Solution {
    public String removeDuplicates(String s, int k) {
      Stack<Pair> stk = new Stack<>();
      
       stk.push(new Pair(s.charAt(0), 1)); 
        
        int i=1;
        
        while(i<s.length()){
            
            
            if(i<s.length() && stk.peek().ch == s.charAt(i))
            {
                // while
            
                stk.peek().c++;
            }else{
                stk.push(new Pair(s.charAt(i), 1));
            }
                i++;
        }
        // System.out.println(stk);    
        
        Stack<Pair> stk2 = new Stack<>();
        
        
        while(!stk.isEmpty()){
            Pair curr = stk.pop();
            
            if(!stk2.isEmpty() && stk2.peek().ch == curr.ch){
                if((stk2.peek().c + curr.c)%k == 0)
                    stk2.pop();
                else 
                    stk2.peek().c = (stk2.peek().c + curr.c)%k;
            }else if(curr.c != k){
                curr.c = curr.c%k;
                stk2.push(curr);
            }
        }
      // System.out.println(stk2);
        
        StringBuilder res = new StringBuilder();
        
        while(!stk2.isEmpty()){
            Pair curr = stk2.pop();
            
            while(curr.c > 0){
                curr.c--;
            res.append(curr.ch);    
            }
            
        }
        return res.toString();
            
            
            
        }
        
    
    class Pair{
        int c;
        char ch;
        Pair(char ch, int c){
            this.c = c;
            this.ch = ch;
       }
        @Override
        public String toString(){
            return this.ch+" "+this.c;
        }
    }

}