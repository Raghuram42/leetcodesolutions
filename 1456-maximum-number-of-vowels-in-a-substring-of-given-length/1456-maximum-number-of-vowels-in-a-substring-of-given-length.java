class Solution {
    public int maxVowels(String s, int k) {
        int i = 0;
        int n = s.length();
        int ans = 0;
        int curr = 0;
        while(i<k){
            if(isVowel(s.charAt(i)))
                curr++;
            i++;
        }
        ans = curr;
        int st = 0;
        while(i<n){
            curr += isVowel(s.charAt(i++)) ? 1: 0;
            curr -= isVowel(s.charAt(st++)) ? 1 : 0;
            
            ans = Math.max(ans, curr);
        }
        return ans;
    }
    
    public boolean isVowel(char c){
        return c =='a' || c == 'e' || c =='i' || c =='o' || c =='u'; 
    }
}