class Solution {
    HashMap<Integer, List<Integer>> g;
    HashMap<Integer, Integer> out;
    List<Integer> path;
    public int[][] validArrangement(int[][] pairs) {
        int n = pairs.length;
        g = new HashMap<>();
        HashMap<Integer, Integer> in = new HashMap<>();
        
      out = new HashMap<>();
        
        
        for(int[] p: pairs){
            in.put(p[1], in.getOrDefault(p[1], 0)+1);
            out.put(p[0], out.getOrDefault(p[0], 0)+1);
            
            if(!g.containsKey(p[0]))
                g.put(p[0], new ArrayList<Integer>());
            g.get(p[0]).add(p[1]);
        }
        
        int st = 0;
        
        for(Integer key: out.keySet()){
            int inValue = in.getOrDefault(key, 0);
            if(out.get(key)-inValue == 1)
            {
                st = key;
                break;
            }
            
            if(inValue > 0)
                st = key;
        }
        
             // System.out.println(st+" "+g+" "+out+" "+in);
        path = new ArrayList<>();
        dfs(st);
        
        int[][] res = new int[path.size()-1][2];
        
        for(int i=1;i<path.size();i++){
            res[i-1] = new int[]{path.get(i-1), path.get(i)};
        }
        // System.out.println(path);
        
        return res;
    }
    
    public void dfs(int curr){
        while(out.containsKey(curr)){
            
            int next = g.get(curr).get(out.get(curr)-1);
            out.put(curr, out.get(curr)-1);
            if(out.get(curr) == 0)
                out.remove(curr);
            dfs(next);
        }
        
        path.add(0, curr);
        
    }
}