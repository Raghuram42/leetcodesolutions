class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        
        Clan[] clans = new Clan[mat.length];
        
        for(int i=0;i<mat.length;i++){
            int noOfSoliders= 0;
            for(int j=0;j<mat[0].length && mat[i][j] >0;j++)
                    noOfSoliders++;
            clans[i] = new Clan(i, noOfSoliders);
        }
        
        Arrays.sort(clans, new SortBySolidersComparator());
        
        int[] res = new int[k];
        
        for(int i=0;i<k;i++)
            res[i] = clans[i].ind;
        
        return res;
    }
    
    class Clan{
        int ind;
        int noOfSolider;
        
        Clan(int ind, int noOfSolider){
            this.ind = ind;
            this.noOfSolider = noOfSolider;
        }
        
        @Override 
        public String toString(){
            return this.noOfSolider+" "+this.ind;
        }
    }
    
    class SortBySolidersComparator implements Comparator<Clan> {
        @Override
        public int compare(Clan c1, Clan c2){
            if(c1.noOfSolider == c2.noOfSolider)
                return c1.ind-c2.ind;
            return c1.noOfSolider-c2.noOfSolider;
        }
    }
}