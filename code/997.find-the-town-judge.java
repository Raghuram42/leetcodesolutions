class Solution {
    int g_dm;
    public int findJudge(int N, int[][] trust) {
        if(trust.length == 0)
            return N;
        HashSet<Integer> hs1 = new HashSet<Integer>();
        int[] res  = new int[N+1];
        for(int[] t : trust)
            hs1.add(t[0]);
        
        g_dm = -1;
        for(int[] t : trust){
            if(!hs1.contains(t[1])){
                if(g_dm == -1)
                    g_dm = t[1];
                else if(g_dm != t[1]){
                    return -1;
                }
            }
        }
        if(g_dm == -1)
             return g_dm;
        System.out.println(g_dm);
        for(int t[] : trust){
            if(t[1] == g_dm)
                res[t[0]] =1;
        }
        for(int i =1;i<=N;i++){
            if(res[i] !=1 && i != g_dm)
                return -1;
        }
        return g_dm;
        
        
        }
        
    //     //System.out.println(new ArrayList<Integer>(Arrays.asList(5)));
    //     return -1;
    // }
    public int found_res(HashMap<Integer, ArrayList<Integer>> hsm, int a){
             if(!hsm.containsKey(a)){
                 return a;
             }
        if(hsm.containsKey(hsm.get(a).get(0)) &&  a == hsm.get(hsm.get(a).get(0)).get(0))
           return -1;
            return found_res(hsm, hsm.get(a).get(0));
    }
}