class Solution {
   
    int[] def;
    
    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        
        def = new int[12];
         
        int ans = solve(numArrows, aliceArrows, 0);
        solve2(numArrows, aliceArrows, 0, ans, new int[12]);

        return def;
    }
    
    public int solve(int arrows, int[] alice, int i){
        if(i>=alice.length)
            return 0;
        int defeatAlice = alice[i]+1;
        
        if(defeatAlice <= arrows){
            int ans1 = i+solve(arrows-defeatAlice, alice, i+1);
            int ans2 = solve(arrows, alice, i+1);
            return Math.max(ans1, ans2);
        }
        
        return solve(arrows, alice, i+1);
    }
    
      public boolean solve2(int arrows, int[] alice, int i, int sum, int[] temp){
          if(sum == 0){
              for(int j=0;j<12;j++)
                  def[j] = temp[j];
              
              if(arrows > 0)
                  def[0]+=arrows;
              return true;
          }
          if(sum < 0)
              return false;
        if(i>=alice.length)
            return false;
          
        int defeatAlice = alice[i]+1;
        
        if(defeatAlice <= arrows){
            temp[i] = defeatAlice;
            if(solve2(arrows-defeatAlice, alice, i+1, sum-i, temp))
                return true;
            temp[i] = 0;
           
        }
        
        return  solve2(arrows, alice, i+1, sum, temp);
    }
    
}
