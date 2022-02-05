class Solution {
    public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
        
        int mincost = Integer.MAX_VALUE;
        
        for(int i=0;i<=9999;i++){
            int sec = getSec(i);
            if(sec == targetSeconds){
               mincost = Math.min(cost(i, moveCost, pushCost, startAt), mincost); 
               // System.out.println(sec+" "+mincost+" "+i); 
            }
        }
        return mincost;
    }
    
    public int getSec(int n){
        int st = n/100;
        int end = n%100;
        
        return (st*60)+end;
    }
    
    public int cost(int i, int m, int p, int st){
        int ans = 0;
        String s = i+"";
        int j = 0;

        while(j<s.length()){
            
            if(s.charAt(j)-'0' == st){
                ans += p;
            }
            else{
                st = s.charAt(j)-'0';
                ans += (m+p);
            }
            j++;
        }
        
        return ans;
        
    }
}
