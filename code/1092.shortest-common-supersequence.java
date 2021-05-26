class Solution {
    class Pair{
        int i;
        int j;
        Pair(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
    public String shortestCommonSupersequence(String str1, String str2) {
       int[][] dp = new int[str1.length()+1][str2.length()+1];
      //  ArrayList<Pair> ary = new ArrayList<Pair>();
        for(int i=1;i<=str1.length();i++){
            for(int j=1;j<=str2.length();j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                 //   ary.add(new Pair(i,j));
                    dp[i][j] = 1 +dp[i-1][j-1];
                }
                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        int lcs = dp[str1.length()][str2.length()];
        if(lcs == 0)
            return str1+str2;
       // System.out.println(lcs);
        StringBuilder ans = new StringBuilder();
     int i= str1.length(); int j = str2.length();
        while(i>0 && j>0){
            if(str1.charAt(i-1) == str2.charAt(j-1))
            {
                ans.append(str1.charAt(i-1));
                i--;
                j--;
            }
            else{
                if(dp[i][j-1] > dp[i-1][j]){
                    ans.append(str2.charAt(j-1));
                    j--;
                }else{
                    ans.append(str1.charAt(i-1));
                    i--;
                }
            }
        }
        while(i>0){
            ans.append(str1.charAt(i-1));
            i--;
            }
        
        while(j>0){
            ans.append(str2.charAt(j-1));
            j--;
            }
        return ans.reverse().toString();
        }
    }

