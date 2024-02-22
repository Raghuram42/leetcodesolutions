class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] trustedBy = new int[n+1];
        int[] trusting = new int[n+1];
        
        for(int[] t: trust){
            trustedBy[t[1]]++;
            trusting[t[0]]++;
        }
        
        for(int i=1;i<=n;i++)
            if(trusting[i] == 0 && trustedBy[i] == n-1)
                return i;
        
        return -1;
    }
}