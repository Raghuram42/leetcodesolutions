class Solution {
 public:
   int findMaxForm(vector<string>& strs, int m, int n) {
      vector < vector <int> > dp(m + 1, vector <int>(n + 1));
      int ret = 0;
      for(int i = 0; i < strs.size(); i++){
         int one = 0;
         int zero = 0;
         for(int j = 0; j < strs[i].size(); j++){
            one += strs[i][j] == '1';
            zero += strs[i][j] == '0';
         }
         for(int j = m; j>= zero; j--){
            for(int k = n; k >= one; k--){
               dp[j][k] = max(dp[j][k], 1 + dp[j - zero][k - one]);
                  ret = max(ret, dp[j][k]);
            }
         }
      }
      return ret;
   }
};