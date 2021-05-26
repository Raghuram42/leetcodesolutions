class Solution {
      int max= 0;
    public int findCircleNum(int[][] isConnected) {
        int[][] nofProvinces = new int[isConnected.length][2];
        
        for(int i=0;i<isConnected.length;i++)
            nofProvinces[i][0] = i;
        
        // int max= 0;
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected.length;j++){
                if(i != j && isConnected[i][j] == 1){
                    union(nofProvinces, i, j);
                    // max++;
                }
            }
        }
        // HashSet<Integer> hst = new HashSet<Integer>();
        // for(int i=0;i<isConnected.length;i++)
        //     hst.add(nofProvinces[i][0]);
        // System.out.println(hst);
        return isConnected.length-max;
    }
    
    public void union(int[][] Prov, int i, int j){
        int p1 = find(i, Prov);
        int p2 = find(j, Prov);
    
        if(p1 == p2)
            return;
        if(Prov[p1][1]>Prov[p2][1]){
            Prov[p2][0] = p1;
            Prov[p1][1]++;
            
        }
        else {
            Prov[p1][0] = p2;
            Prov[p2][1]++;
        }
        max++;

    }
    
//     public int find(int i, int[][] Prov){
        
//         int p1 = Prov[i][0];
        
//         while(p1 != Prov[p1][0])
//             p1 = Prov[p1][0];
        
//         int par = p1;
        
        
//         while(i != Prov[i][0])
//         {
//             i = Prov[i][0];
//             Prov[i][0] = par;
//         }
//         return par;
        
//     }
      public int find(int i,  int[][] Prov){
            if(Prov[i][0] != i){
                Prov[i][0] = find(Prov[i][0], Prov);
            }
            return Prov[i][0];
        }
}