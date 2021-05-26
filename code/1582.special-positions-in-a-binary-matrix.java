class Solution {
	public int numSpecial(int[][] mat) {
		int m = mat.length; 
		int n = mat[0].length;
		int count=0;
		int []rowSum = new int[m];
		int []colSum = new int[n];
		// compute sum for each row
		for(int i=0; i<m; ++i){
			for(int j=0; j<n; ++j){
				rowSum[i] += mat[i][j]; 
			}
		}
		// compute sum for each col
		for(int i=0; i<n; ++i){
			for(int j=0; j<m; ++j){
				colSum[i] += mat[j][i]; 
			}
		}
		// if rowSum[i] == colSum[j] == 1 and mat[i][j] == 1, we find a special location
		for(int i=0; i<m; ++i){
			for(int j=0; j<n; ++j){
				if(colSum[j] + rowSum[i] == 2 && mat[i][j] == 1)
					count++;
			}    
		}       
		return count;
	}
}