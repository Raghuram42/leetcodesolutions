class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int[] mapr = new int[26];
        
        for(int i=0;i<allowed.length();i++)
            mapr[allowed.charAt(i)-'a']++;
        
        int res = 0;
        for(int i=0;i<words.length;i++){
            boolean hasAll = true;
            for(int j=0;j<words[i].length();j++){
                if(mapr[words[i].charAt(j)-'a'] == 0){
                 hasAll = false;
                    break;
                }
            }
            if(hasAll)
                res++;
        }
        
        return res;
    }
}