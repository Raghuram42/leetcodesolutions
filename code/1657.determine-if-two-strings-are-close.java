class Solution {
    public boolean closeStrings(String word1, String word2) {
        int[] mapr1 = new int[26];
        int[] mapr2 = new int[26];
        
        if(word1.length() != word2.length())
            return false;
        
        for(int i=0;i<word1.length();i++){
            mapr1[word1.charAt(i)-'a']++;
            mapr2[word2.charAt(i)-'a']++;
        }
        
       for(int i=0;i<26;i++){
           if(mapr1[i] == 0 && mapr2[i] != 0  || mapr1[i] != 0 && mapr2[i] == 0)
               return false;
       }        
        
        Arrays.sort(mapr1);
        Arrays.sort(mapr2);
        
        
       for(int i=0;i<26;i++){
           if(mapr1[i] != mapr2[i])
               return false;
       }        
        
        
        
        
        return true;
    }
}