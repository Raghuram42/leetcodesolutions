class Solution {
    int MAX = (2*10*10*10*10)+1;
    public int candy(int[] ratings) {
        // int[] reverseIndex = new int[MAX];
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->a[0]-b[0]);
        
        int i = 0;
        int n = ratings.length;
        int[] dp = new int[ratings.length];
        
        while(i<n){
            pq.offer(new int[]{ratings[i], i});
            dp[i++] = 1;
        }
        
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            
            int index = curr[1];
            
            if(index-1 >= 0 && ratings[index] > ratings[index-1] && dp[index] <= dp[index-1])
                dp[index] = dp[index-1]+1;
            
            if(index+1 < n && ratings[index] > ratings[index+1] && dp[index] <= dp[index+1])
                dp[index] = dp[index+1]+1;
        }
        
        int res = 0;
        for(i=0;i<n;i++)
            res += dp[i];
        
        return res;
    }
}