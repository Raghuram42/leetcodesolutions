class Solution {
    boolean[] vis;
    int[] dp;
    public int longestStrChain(String[] words) {
        int n = words.length;
        vis = new boolean[n];
        dp = new int[n];
        Arrays.fill(dp, -1);
        int res = 0;
        
        for(int i=0;i<n;i++)
        {
            res = Math.max(res, solve(words, i));
        }
        // res++;
        
        return res;
    }
    
    
    public int solve(String[] words, int i){
        if(i >= words.length)
            return 0;
        
        if(dp[i] != -1)
            return dp[i];
        int res = 0;
        int n = words.length;
        vis[i] = true;
        for(int j=0;j<n;j++){
                // System.out.println(words[i] +" out "+ words[j]);
            if(!vis[j] && i != j && same(words[i], words[j])){
                // System.out.println(words[i] +" "+ words[j]);
                // vis[j] = true;
            res = Math.max(res, solve(words, j));
                // vis[j] = false;
            }
            
        }
        
        vis[i] = false;
        return dp[i] = res+1;
    }
    
    public boolean same(String w1, String w2){
        if(w1.length() == w2.length())
            return false;
        int st = 0;
        int end = 0;
        int n1 = w1.length();
        int n2 = w2.length();
        int diff = 0;
        while(st < n1 || end < n2){
            if(st<n1 && end<n2 && w1.charAt(st) == w2.charAt(end) ){
                st++;
                end++;
            }else{
                diff++;
                end++;
            }
            
            if(diff > 2)
                return false;
        }
        return diff == 1;
    }
    
}

//solve(words, i=0)
/*

{
    > len
        return 0;
    res = 1;
    for(j=0 to n)
    {
        vis[j] = t;
        if(i != j && same(i, j))
          max(res, solve(words, j));
        vis[j] = f;
    }
        ret rs;
}

same(t1, t2){
    int f= 0;
    int s=0;
    int diff = 0;
    while(f<n1 ||  s<n2){
        if(f<n1 &&  s<n2 && equal)
        {
            f++;
            s++;
        }else{
            diff++;
            s++;
        }
        
        if(diff > 1)
            break;
    }
    
    ret dif == 1; 
}

ba b
*/
/*
Old solution 

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
*/
