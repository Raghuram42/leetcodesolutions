class Solution {
    public String licenseKeyFormatting(String S, int K) {
        Stack<Character> res = new Stack<Character>();
        int p = 0;
        for(int i=S.length()-1;i>=0;i--){
            if(S.charAt(i) != '-'){
                res.push(Character.toUpperCase(S.charAt(i)));
                p++;
            }
            if(p == K ){
                res.push('-');
                p = 0;
            }
        }
        
        StringBuilder str = new StringBuilder();
          while(!res.isEmpty() && res.peek() == '-')
              res.pop();
        while(!res.isEmpty())
            str.append(res.pop());
        
        return str.toString();
    }
}