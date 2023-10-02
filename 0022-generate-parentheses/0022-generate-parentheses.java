class Solution {
    List<String> res;
    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        s(n, n, new StringBuilder());
        return res;
    }
    
    public void s(int open, int close, StringBuilder str){
        if(open == 0 && close == 0){
            res.add(str.toString());
            return;
        }
        
        if(open < close)
        {
            str.append(")");
            s(open, close-1, str);
            str.deleteCharAt(str.length()-1);
        }
        if(open > 0){
        str.append("(");
        s(open-1, close, str);
        str.deleteCharAt(str.length()-1);
        }
    }
}
/*
o = 3 
    
c = 3

o == 0 && c == 0
    add to g
    return;


o > 0 && o <= c
 send o
 
 send c ;

*/
 
