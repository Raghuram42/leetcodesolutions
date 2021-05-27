class Solution {
    public int maxProduct(String[] words) {
        int[][] wordMap = new int[words.length][26];
        
        for(int i=0;i<words.length;i++)
            wordMap[i] = getMap(words[i]);
        int res = 0;
        for(int i=0;i<wordMap.length;i++){
            for(int j=i+1;j<wordMap.length;j++){
                if(hasSameChars(wordMap[i], wordMap[j]))
                    res = Math.max(res, words[i].length()*words[j].length());
            }
        }
        
        return res;
    }
    
    public int[] getMap(String word){
        int[] map = new int[26];
        
        for(int i=0;i<word.length();i++)
            map[word.charAt(i)-'a']++;
        
        return map;
    }
    
    public boolean hasSameChars(int[] map1, int[] map2){
        
        for(int i=0;i<26;i++)
            if(map1[i] > 0 && map2[i]>0)
                return false;
        return true;
    }
}