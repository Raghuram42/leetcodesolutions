class Solution {
    public long numberOfWays(String s) {
        int n = s.length();
        int[][] left = new int[n+1][2];
        int[][] right = new int[n+1][2];
        int i = 0;
        
        while(i<n){
            int p = s.charAt(i)-'0';
            int q = p == 1? 0: 1;
            left[i][p]=i-1 >=0 ? left[i-1][p]+1: 1;
            left[i][q]=i-1 >=0 ? left[i-1][q]: 0;
          
            i++;
        }
        
        
        i = n-1;
        while(i>=0){
            int p = s.charAt(i)-'0';
            int q = p == 1? 0: 1;
            right[i][p] = right[i+1][p]+1;
            right[i][q] = right[i+1][q];
            i--;
        }

        
        long ans = 0;
        
        i = 1;
        
        while(i<n){
            int p = s.charAt(i)-'0';
            p = p == 1 ? 0 : 1;
            ans += left[i-1][p]*1l*right[i+1][p];
            i++;
        }
        
        return ans;
    }
}
