class Solution {
    class Pair{
        int cost;
        int des;
        Pair(int des, int cost){
            this.des = des;
            this.cost = cost;
        }
    }
    int res;
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) { 
        HashMap<Integer, ArrayList<Pair>> hsm = new HashMap<Integer, ArrayList<Pair>>();
        
        for(int i=0;i<flights.length;i++){
           if(!hsm.containsKey(flights[i][0])) 
               hsm.put(flights[i][0], new ArrayList<Pair>());
            
           hsm.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        int p = 0;
        int price = 0;
     
        
       res =  Integer.MAX_VALUE;        
    traverse(src, dst, K+1, 0, hsm);
       // System.out.println(res);
     return res == Integer.MAX_VALUE ? -1: res;   
    }
    
    
    public void traverse(int src, int des, int K, int cheap_price, HashMap<Integer, ArrayList<Pair>> hsm){
       if(K < 0){
           return; 
       }
        
        if(src == des){
            res = cheap_price;
            return;
        }
        
        if(hsm.containsKey(src)){
            for(Pair tmp : hsm.get(src)){
                if(cheap_price + tmp.cost < res)
                    traverse(tmp.des, des, K-1, cheap_price + tmp.cost, hsm);
            }
        }
    }
}