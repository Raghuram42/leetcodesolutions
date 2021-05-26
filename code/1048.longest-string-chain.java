class Solution {
    int[][][] dp;
    public int longestStrChain(String[] words) {
        HashMap<Integer, List<String>> lengthWise = new HashMap<Integer, List<String>>();
        dp = new int[17][1001][1001];
        
        for(int i=0;i<=16;i++){
            for(int j=0;j<=1000;j++)
                Arrays.fill(dp[i][j], -1);
        }
        int maxwordlen = 0;
        for(String w: words){
            maxwordlen = Math.max(maxwordlen, w.length());
            
            if(!lengthWise.containsKey(w.length()))
                lengthWise.put(w.length(), new ArrayList<String>());
            
            lengthWise.get(w.length()).add(w);
            
        }
        // System.out.println(lengthWise);
        int max = 0;
        
        for(int i=0;i<=maxwordlen;i++){
            for(int k=0;lengthWise.containsKey(i) && k<lengthWise.get(i).size();k++)
            max = Math.max(solve(lengthWise, i, k, 0), max);
            // if(max == 9)
                // System.out.println(i+" "+max);
        }
        
        // return solve(lengthWise, 1, 0, 0);
        return max+1;
    }
    
    public int solve(HashMap<Integer, List<String>> mp, int currLen, int i, int j){
        
        if(!mp.containsKey(currLen) || !mp.containsKey(currLen+1))
            return 0;
        
        if(i >= mp.get(currLen).size() || j >= mp.get(currLen+1).size())
            return 0;
        if(dp[currLen][i][j] != -1)
            return dp[currLen][i][j];
        String currLenString = mp.get(currLen).get(i);
        String currLenPlusOneString = mp.get(currLen+1).get(j);
        
        
        if(match(currLenString, currLenPlusOneString))
            return dp[currLen][i][j] = Math.max(1+solve(mp, currLen+1, j, 0), solve(mp, currLen,  i, j+1));
        
        return dp[currLen][i][j] = solve(mp, currLen,  i, j+1);
        
            
    }
    
    
    public boolean match(String f, String s){
        if(f.length()+1 != s.length())
            return false;
        
        int i=0;
        int j=0;
        
        
        int same = 0;
        while(i<f.length() && j<s.length()){
            if(f.charAt(i) == s.charAt(j)){
                i++;
                j++;
                same++;
            }
            else{
                j++;
            }
        }
        // if(same == f.length())
        // System.out.println(f+" "+s+" "+same);
        return same == f.length();
        
    }
}