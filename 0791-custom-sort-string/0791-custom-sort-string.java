class Solution {
    public String customSortString(String order, String str) {
        int[] map = new int[26];
        
        for(int i=0;i<str.length();i++){
            map[str.charAt(i)-'a']++;
        }
        
        StringBuilder res = new StringBuilder();
        
        for(int i=0;i<order.length();i++){
          
            
            while(map[order.charAt(i)-'a'] > 0){
                res.append(order.charAt(i));
                map[order.charAt(i)-'a']--;
            }
        
        }
        
        
        for(int i=0;i<26;i++){
            while(map[i] > 0){
                res.append((char)(i+'a'));
                map[i]--;
            }
        }
        return res.toString();
    }
}