class Solution {
    public String freqAlphabets(String s) {
        int i = s.length()-1;
        StringBuilder res = new StringBuilder();
        while(i>=0){
            
            if(s.charAt(i) == '#'){
                i--;
                int p=i;
                String num = "";
                while(p>i-2){
                    num = s.charAt(p)+num;
                    p--;
                }
                int n = Integer.parseInt(num);    
                n = n-1;
                char c = (char)(n+'a');
                i = p;
                res.append(c);
            }
            else{
            char c = (char)(((s.charAt(i)-'0')-1)+'a');
            res.append(c);
            i--;
            }
        }
        
        return res.reverse().toString();
    }
}