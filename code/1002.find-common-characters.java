class Solution {
    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<String>();
        
        if(A.length == 0)
            return res;
        int[][] mapr = new int[A.length][26];
        int p = 0;
        
        for(String s: A){
            for(int i=0;i<s.length();i++){
                mapr[p][s.charAt(i)-'a']++;
                if(p != 0)
                    mapr[p][s.charAt(i)-'a'] = Math.min(mapr[p-1][s.charAt(i)-'a'], mapr[p][s.charAt(i)-'a']);
            }
            p++;
        }
        
        for(int i=0;i<26;i++){
            while(mapr[A.length-1][i] > 0){
                res.add(String.valueOf((char)(i+'a')));
                mapr[A.length-1][i]--;
            }
        }
        
        return res;
    }
}
