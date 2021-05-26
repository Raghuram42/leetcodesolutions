class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] mapr = new int[words.length];
        
       int[] res = new int[queries.length];
        for(int i=0;i<words.length;i++)
            mapr[i] = getmapr(words[i]);
        
        for(int i=0;i<queries.length;i++){
            int currfreq = getmapr(queries[i]);
            
            for(int j=0;j<mapr.length;j++){
                if(currfreq < mapr[j])
                  res[i]++;  
                    
            }
            // mapr[i] = getmapr(word, mapr[i]);
        }
        return res;
        
    }
    
    
    public int getmapr(String s){
        
        if(s.length() == 0 )
            return 0;
        
        int[] map = new int[26];
        int min = s.charAt(0)-'a';
        for(int i=0;i<s.length();i++){
            min = Math.min(min, s.charAt(i)-'a');
            map[s.charAt(i)-'a']++;
        }
        
        return map[min];
    }
}