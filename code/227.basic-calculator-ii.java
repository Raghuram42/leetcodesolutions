class Solution {
     HashSet<Character> hst;
    int i;
    public int calculate(String s) {
        Stack<Character> oper = new Stack<Character>();
        Stack<Integer> numb = new Stack<Integer>();
        hst = new HashSet<Character>();
        hst.add('+');
        hst.add('*');
        hst.add('-');
        hst.add('/');
        i = 0;
        while(i<s.length()){
            
            char c = s.charAt(i);
        
            if(Character.isWhitespace(c)){
                i++;
                continue;
            }
            
            if(hst.contains(c)){
                        // System.out.println(c+"  "+numb.peek()+" "+den);
                if(c != '+'){
                    i++;
                    int den = getnum(s);
                
                    if(c-'/' == 0)
                      numb.push(numb.pop()/den);
                    else if(c == '*')
                        numb.push(numb.pop()*den);
                    else 
                        numb.push(den*-1);
                }else
                    i++;
            }
            else{
              numb.push(getnum(s));
            }
       
           
        }
        
        while(numb.size() > 1){
                numb.push(numb.pop()+numb.pop());
            // ope.pop();
        }
        return numb.pop();
    }
    public int getnum(String s){
        int num = 0;
        while(i<s.length() && Character.isWhitespace(s.charAt(i)))
            i++;
        while(i<s.length() && !hst.contains(s.charAt(i)) && !Character.isWhitespace(s.charAt(i))){
            num = num*10 + (s.charAt(i)-'0');
            i++;
        }
          // System.out.println(i+" i ");
        return num;
    }
}