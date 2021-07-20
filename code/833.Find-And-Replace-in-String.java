class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
     int[][] indexes = new int[1001][2];
        
        for(int i=0;i< indices.length;i++){
            indexes[indices[i]][0] = 1;
            indexes[indices[i]][1] = i;
        }
        
        StringBuilder res = new StringBuilder();
        int i = 0;
        int n = s.length();            
        while(i < s.length()){
            if(indexes[i][0] == 1){
                int k = 0;
                int p = indexes[i][1];
                int q = sources[p].length();
                if(sources[p].equals(s.substring(i, i+q))){
                    res.append(targets[p]);
                    i = i+q;
                    continue;
                }
                
            }
                res.append(s.charAt(i));
                i++;
            
        }
        
        return res.toString();
    }
}
