class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] inp = s.split(" ");
        int n = inp.length;
        StringBuilder res = new StringBuilder();
        int i = n-1;
        
        while(i >=0){
            if(inp[i].length() > 0)
                res.append(inp[i]).append(" ");
            i--;
        }
        
        
        res.deleteCharAt(res.length()-1);
        return res.toString();
    }
}