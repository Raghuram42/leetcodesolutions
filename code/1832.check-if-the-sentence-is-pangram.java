class Solution {
    public boolean checkIfPangram(String sentence) {
        boolean[] allLett = new boolean[26];
        
        for(int i=0;i<sentence.length();i++)
            allLett[sentence.charAt(i)-'a'] = true;
        
        for(int i=0;i<26;i++)
            if(!allLett[i])
                return false;
        
        return true;
            
    }
}