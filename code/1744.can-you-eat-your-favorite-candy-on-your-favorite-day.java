class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        long[] prefixsum = new long[candiesCount.length+1];
        // prefixsum[0] = candiesCount[0];
        
        for(int i=0;i<candiesCount.length;i++)
            prefixsum[i+1] = (prefixsum[i]+candiesCount[i]);
        
        boolean[] res = new boolean[queries.length];
        for(int i=0;i<queries.length;i++){
             int type = queries[i][0], day = queries[i][1], cap = queries[i][2];
            long curr = prefixsum[type + 1], prev = prefixsum[type], least = day + 1, most = cap * 1l *(day + 1);
            if(least > curr || most <= prev)
                res[i] = false;
            else
                res[i] = true;
        }
        
        return res;
    }
}