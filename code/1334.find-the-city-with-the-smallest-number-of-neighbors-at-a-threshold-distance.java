class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] adjmat = new int[n][n];
        
        
            for(int i = 0; i < n; i++){
           // Arrays.fill(adjmat[i],Integer.MAX_VALUE);
			// If int[][] 
            Arrays.fill(adjmat[i],12345); 
            adjmat[i][i] = 0;
        }
        for(int[] ed: edges){
            adjmat[ed[0]][ed[1]] = ed[2];
            adjmat[ed[1]][ed[0]] = ed[2];
        }
        
        for(int k = 0; k < n; k++){
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    adjmat[i][j] = Math.min(adjmat[i][j],adjmat[i][k] + adjmat[k][j]);
                }
            }
        }
        
          int maxVisits = n+1;
        int result = -1;
        
        for(int i = 0; i < n; i++) {
            int visit = 0;
            for(int j = 0; j < n; j++) {
                if(adjmat[i][j] <= distanceThreshold) visit++;
            }
            if(visit <= maxVisits){
                result = i;
                maxVisits = Math.min(maxVisits,visit);
            }
        }
        return result;
        
    }
}