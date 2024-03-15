class Solution {
    public String reverseVowels(String s) {
        StringBuilder res = new StringBuilder();
        
        StringBuilder map = new StringBuilder();
        
        int i = 0;
        int n = s.length();
        
        while(i<n){
            
            if(Character.toLowerCase(s.charAt(i)) == 'a' || Character.toLowerCase(s.charAt(i)) == 'e' || Character.toLowerCase(s.charAt(i)) == 'i' || Character.toLowerCase(s.charAt(i)) == 'o' || Character.toLowerCase(s.charAt(i)) == 'u')
                map.append(s.charAt(i));
            
            i++;
        }
        
        i = 0;
        int sz = map.length()-1;
        
        while(i<n){

            
            if(Character.toLowerCase(s.charAt(i)) == 'a' || Character.toLowerCase(s.charAt(i)) == 'e' || Character.toLowerCase(s.charAt(i)) == 'i' || Character.toLowerCase(s.charAt(i)) == 'o' || Character.toLowerCase(s.charAt(i)) == 'u')
                res.append(map.charAt(sz--));
            else
                res.append(s.charAt(i));
            i++;
        }
        
        return res.toString();
    }
    public char ch(char c){
        return Character.toLowerCase(c);
    }
}