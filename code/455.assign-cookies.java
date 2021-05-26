class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        
        
        int i = g.length-1;
        int j = s.length-1;
        
        int res = 0;
        while(i>=0 && j>=0){
            if(s[j] >= g[i]){
                i--;
                j--;
                res++;
            }else
                i--;
        }
        
        
        return res;
    }
}