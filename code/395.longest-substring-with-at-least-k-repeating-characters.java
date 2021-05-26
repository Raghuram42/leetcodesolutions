class Solution {
    public int longestSubstring(String s, int k) {
    
        int[] mapr = new int[26];
        
        int res = 0;
        for(int i=0;i<s.length();i++){
            int v = s.charAt(i)-'a';
            
            mapr[v]++;
        }
        HashSet<Integer> splits = new HashSet<Integer>();
        for(int i=0;i<26;i++){
            if(mapr[i]<k && mapr[i] > 0)
                splits.add(i);
        }
        
        if(splits.size() == 0)
            return s.length();
        
        int i = 0 ;
        int j = 0;
        
        while(j<s.length()){
            int c = s.charAt(j)-'a';
            if(splits.contains(c)){
                if(j != i){
                    res = Math.max(res, longestSubstring(s.substring(i,j), k));
                }
                i = j+1;
            }
            j++;
        }
        if(j != i)
                    res = Math.max(res, longestSubstring(s.substring(i,j), k));
            
        return res;
    }
}