class Solution {
    class Pair{
        String first;
        double value;
        Pair(String first, double value){
           this.first = first;
           this.value = value;
        }
    }
    HashMap<String, List<Pair>> hsm;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        hsm = new HashMap<String, List<Pair>>();
        
        for(int i=0;i<equations.size();i++){
            String key = equations.get(i).get(0);
            String first = equations.get(i).get(1);
            double value = values[i];
            if(!hsm.containsKey(key))
            hsm.put(key, new ArrayList<Pair>());
            hsm.get(key).add(new Pair(first, value));
            if(!hsm.containsKey(first))
            hsm.put(first, new ArrayList<Pair>());
            hsm.get(first).add(new Pair(key, 1/value));
        }
        double[] res = new double[queries.size()];
        int itr = 0;
        for(List<String> q : queries){
            String first = q.get(0);
            String second = q.get(1);
            
            if(!hsm.containsKey(first) || !hsm.containsKey(second)){
                res[itr++] = -1.0;
            }else 
                if(first.equals(second))
                res[itr++] = 1.0;
            else {
                int ansf = 0;
                if(hsm.containsKey(first) && hsm.containsKey(second)){
                    List<Pair> f1 = hsm.get(first);
                    double ans = -1;
                    for(Pair all: f1){
                        
                        Queue<Pair> que = new LinkedList<Pair>();
                        
                        que.offer(all);
                        HashSet<String> hst = new HashSet<String>();
                        
                        hst.add(first);
                        ans = solve(all, second, 1, hst);     
              //         System.out.println(" ans "+ans);
                        if(ans != -1)
                        {
                            //ans = a;
                            break;
                        }
                        
//                         while(que.size()>0){
//                             Pair curr =  que.poll();
                            
//                             hst.add(curr.first);
//                           System.out.println(first+" "+second+" "+curr.first+" "+curr.value+" "+ans+" vis "+hst);
//                             if(curr.first.equals(second)){
//                              res[itr++] = ans*curr.value;
//                                 ansf = 1;
//                                 break;
//                             }
//                             else{
//                                 ans *= curr.value;
//                                 int k = 0; 
//                                 for(Pair p: hsm.get(curr.first)){
//                                 que.offer(p);
//                                 k++;
//                                 }
//                             }
//                         }
                      
//                     }
                }
                    
                    //if(ansf == 0)
                       res[itr++] = ans;
            }
        }
        }
        
        //System.out.println(hsm);
     return res;   
    }
    
    public double solve(Pair f, String sec, double ans, HashSet<String> hst){
        
        
        if(hst.contains(f.first))
           return -1;
        
        hst.add(f.first);
        ans *= f.value;
//System.out.println(sec+" "+f.first+" "+f.value+" "+ans+" vis "+hst);
        if(f.first.equals(sec))
        return ans;
        
        for(Pair p: hsm.get(f.first)){
            if(!hst.contains(p)){
            double tmp  = solve(p, sec, ans, hst);
                if(tmp != -1)
                    return tmp;
            }
        }
                    
        return -1;                          
    }
}
