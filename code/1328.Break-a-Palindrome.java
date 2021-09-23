class Solution {
    public String breakPalindrome(String palindrome) {
        if(palindrome.length()==0)
            return "";
        char[] pal = palindrome.toCharArray();
        int n = pal.length;
        String res = "";
        for(int i=0;i<n;i++){
            char prev = pal[i];
            for(char c = 'a';c<='z';c++){
                pal[i] = c;
                if(palindrome.charAt(i) != c && notPalind(pal) && (res.length() == 0 || res.compareTo(new String(pal)) > 0) )
                    res = new String(pal);
                    
            }
            pal[i] = prev;
            
        }
        
        return res;
    }
    
    public boolean notPalind(char[] inp){
        int i = 0;
        int n = inp.length-1;
        
        while(i<n){
            if(inp[i] != inp[n])
                return true;
            
            i++;
            n--;
        }
        
        return false;
    }
}
