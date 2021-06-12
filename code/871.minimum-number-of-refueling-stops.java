class Solution {
    HashMap[] dp;
    int itr;
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        itr = 0;
        dp = new HashMap[stations.length];
        for(int i=0;i<stations.length;i++)
            dp[i] = new HashMap<Integer, Integer>();
        // System.out.println(stations.length);
        // int res = solve(stations, 0, startFuel, target);
        
      // return res >= Integer.MAX_VALUE-10 ? -1: res; 
        HashMap<Integer, Pair> map = new HashMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, startFuel));
        map.put(0, q.peek());
        int res = 0;
        while(!q.isEmpty()){
            int sz= q.size();
            map = new HashMap<>();
            while(sz>0){
                Pair curr = q.poll();
                 
                if(curr.b >= target)
                    return res;
                if(!map.containsKey(curr.a))
                    map.put(curr.a, curr);
                for(int i=curr.a;i<stations.length;i++){
                    if(curr.b >= stations[i][0]){
                        
                if(!map.containsKey(i+1)){
                    map.put(i+1, new Pair(i+1, curr.b+stations[i][1]));
                    q.offer(map.get(i+1));
                }else{
                    map.get(i+1).b = Math.max(map.get(i+1).b, curr.b+stations[i][1]);
                    // q.offer(ma.get(i+1));
                    }
                }
                }
                
                
                sz--;
            }
            // System.out.println(q.size()+" "+q);
            res++;
        }
        
        return -1;
        
    }
    
    public int solve(int[][] stations, int i, int fuel, int des){
        if(fuel >= des)
            return 0;
        if(i>=stations.length || stations[i][0] > fuel)
            return Integer.MAX_VALUE-1;
        
        if(dp[i].containsKey(fuel))
            return (int)dp[i].get(fuel);
        itr++;
        int res = Math.min(solve(stations, i+1, fuel, des), 1+solve(stations, i+1, fuel+stations[i][1], des));
        dp[i].put(fuel, res);
        return res;
    }
    class Pair{
        int a;
        int b;
        
        Pair(int a, int b){
            this.a = a;
            this.b = b;
        }
        
        @Override
        public String toString(){
            return "["+ this.a+", "+this.b+"]";
        }
    }
}

// class 
/*
//start -> 0+startfuel search from back in station array
target = 100, startFuel = 10, stations = [[10,60],[20,30],[30,30],[60,40]]
        ary     0  10         100
solve(stations, i, startfuel, target)
    if(startfuel >= target)
        return 0;
    if(i>= stations.length)
        return IntMAX;
    
    
if(stations[i][0] > startfuel)
    return IntMIn;

return Min(solve(stations, i+1, startfuel), 1+solve(stations, i+1, startfuel+stations[i][1]) );
    */