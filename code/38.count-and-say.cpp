class Solution {
	public:
		int all[3][3][10];
		int row[9][10],col[9][10];
		bool solve(int i,int j,vector<vector<char>>& A){
			if(j==9)i++,j=0;
			if(i==9)return 1;  
			if(A[i][j]!='.')return solve(i,j+1,A);
			for(char d='1';d<='9';d++){
				int x=d-'0';
				if(!row[i][x]&&!col[j][x]&&!all[i/3][j/3][x]){
					 row[i][x]=col[j][x]=all[i/3][j/3][x]=1;
					 A[i][j]=d;
					 if(solve(i,j+1,A))return 1;
					 A[i][j]='.';
					 row[i][x]=col[j][x]=all[i/3][j/3][x]=0;
				 }
			}
			return 0;

		}
		void solveSudoku(vector<vector<char>>& board) {
			for(int i=0;i<9;i++){
				for(int j=0;j<9;j++){
					if(board[i][j]!='.'){
						int x=board[i][j]-'0';
						row[i][x]=col[j][x]=all[i/3][j/3][x]=1;
					}
				}
			}
			solve(0,0,board);
		}
	};