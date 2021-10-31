class Solution {
    int[][] dp;
    // Set<Integer>
    public int minimumOperations(int[] nums, int start, int goal) {
        // dp = new int[1001][1001];
        // int res = solve(nums, 0, 0, start, goal , new ArrayList<Integer>());
        
        HashSet<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        
        q.offer(start);
        
        int ans  = 0;
        int n = nums.length;
        while(!q.isEmpty()){
            int sz = q.size();
            
            while(sz > 0){
            int curr = q.poll();
            // System.out.println(curr);
            if(curr == goal)
                return ans;
            if(curr < 0 || curr > 1000 || set.contains(curr)){
                sz--;
                continue;
            }
            
            set.add(curr);
            for(int i=0;i<n;i++){
                q.offer(curr+nums[i]);
                q.offer(curr-nums[i]);
                q.offer(curr^nums[i]);
            }
                sz--;
            }
            ans++;
        }
        
        // System.out.println(res+" "+set);
        return -1;
    }
    public int solve(int[] nums, int i, int dis, int st, int goal, ArrayList<Integer> tmp){
        if(goal == st){
            System.out.println(tmp+" "+goal);
            return dis;
        }
        
        if(st < 0 || st > 1000 || i >= nums.length || dp[st][i] == -1)
            return Integer.MAX_VALUE-10000;
        if(dp[st][i] != 0)
            return dp[st][i];
        dp[st][i] = -1;
        // set.add(st);
        // System.out.println(st);
        int wOut = solve(nums, i+1, dis, st, goal,  new ArrayList<Integer>(tmp));
        tmp.add(st);
        wOut = Math.min(solve(nums, i, dis+1, st+nums[i], goal, new ArrayList<Integer>(tmp)), wOut);
        wOut = Math.min(solve(nums, i, dis+1, st-nums[i], goal,  new ArrayList<Integer>(tmp)), wOut);
        wOut = Math.min(solve(nums, i, dis+1, st^nums[i], goal,  new ArrayList<Integer>(tmp)), wOut);
        return dp[st][i] = wOut;
        
        
        
        
    }
}
