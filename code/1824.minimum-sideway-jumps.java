class Solution {
    public int minSideJumps(int[] obstacles) {
        // Optimial side jumps needed to reach (point, lane)
        int[][] dp = new int[obstacles.length][3];
        dp[0][0] = 1;
        dp[0][1] = 0;
        dp[0][2] = 1;
        for (int i = 1; i < obstacles.length; i++) {
            int[] straightFromPrevPoint = new int[3];
            // the current point's obstacle lane index
            int obstacleIndex = obstacles[i] - 1;
            // jumps already took from previous point
            for (int lane = 0; lane < 3; lane++) {
                straightFromPrevPoint[lane] = obstacleIndex == lane ? Integer.MAX_VALUE : dp[i - 1][lane];
            }
            // side jumps
            for (int current = 0; current < 3; current++) {
                dp[i][current] = straightFromPrevPoint[current];
                if (obstacleIndex == current) {
                    continue;
                }
                for (int other = 0; other < 3; other++) {
                    if (current == other || straightFromPrevPoint[other] == Integer.MAX_VALUE) {
                        continue;
                    }
                    dp[i][current] = Math.min(dp[i][current], straightFromPrevPoint[other] + 1);
                }
            }
        }
        return Math.min(dp[obstacles.length - 1][0], Math.min(dp[obstacles.length - 1][1], dp[obstacles.length - 1][2]));
    }
}