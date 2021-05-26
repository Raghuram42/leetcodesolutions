class Solution {
    public boolean halvesAreAlike(String s) {
        
        int c=0;
        int mid = s.length()/2;
        for(int i=0;i<s.length();i++){
            if(!isaVowel(s.charAt(i)))
                continue;
            if(i < mid)
                c++;
            else
                c--;
        }
        
        return c == 0;
    }
    public boolean isaVowel(char c){
        c = Character.toLowerCase(c); 
        if(c =='a' || c=='e' || c == 'i' || c == 'o' || c == 'u')
            return true;
        return false;
            
    }
}