class Solution {
    HashMap<Integer, HashSet<Integer>> hsm; 
    public boolean canCross(int[] stones) {
        hsm = new HashMap<Integer, HashSet<Integer>>();
        for(int s: stones)
            hsm.put(s, new HashSet<Integer>());
        return solve(stones, 0, 1, 1);
    }
    
    public boolean solve(int[] stones, int i, int j, int steps){
        if(j<0 || j>stones.length)
            return false;
        if(j == stones.length-1 && stones[j]-stones[i] == steps)
            return true;
       
      //  int steps = stones[j]-stones[i];
        boolean res = false;;
        for(int k=j+1;k<stones.length;k++){
           int st = stones[k]-stones[j];
            HashSet<Integer> hst = hsm.get(stones[k]);
            if(st == steps-1 && !hst.contains(steps-1)){
                hst.add(steps-1);
                res = res || solve(stones, j, k, steps-1);  
            }
                  if(res) 
                return  res;
            if( st == steps && !hst.contains(steps)){
                hst.add(steps);
                res = res || solve(stones, j, k, steps);    
            }
                  if(res) 
                return res;
            if(st == steps+1 && !hst.contains(steps+1)){
                hst.add(steps+1);
                res = res || solve(stones, j, k, steps+1);    
            }
            if(res) 
                return res;
        }
        return  res;
    }
}