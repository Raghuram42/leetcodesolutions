class Solution {
    
    public boolean winnerSquareGame(int n) {
    boolean[] map = new boolean[n+1];
        map[0] = false;
    for(int i=1;i*i<=n;i++)
        map[i*i] = true;
     
     for(int i=1;i<=n;i++){
         // if(map[i] == null)
         // {
             for(int j =1;j*j<=i;j++)
             {
                 if(!map[i-(j*j)])
                {
                     map[i] = true;
                     break;
                 }
             // }
         }
     }   
        return map[n];   
    }
} 