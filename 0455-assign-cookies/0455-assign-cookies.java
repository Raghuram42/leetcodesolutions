class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        
        int l = 0;
        int r = 0;
        int n = g.length;
        int m = s.length;
        int res = 0;
        while(l<n && r < m){
            if(s[r] >= g[l]){
                l++;
                r++;
                res++;
            }
            else{
                r++;
            }
        }
        
        return res;
    }
}