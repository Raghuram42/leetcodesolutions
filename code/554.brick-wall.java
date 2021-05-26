class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        if(wall.size() == 0)
            return 0;
   
     // int res =0;
        HashSet[] hsts = new HashSet[wall.size()];
        HashSet<Integer> all = new HashSet<>();
        int allsum =0;
        int sum =0;
        int maxs = Integer.MIN_VALUE;
        for(int i=0;i<wall.size();i++){
            sum =0;
            
            hsts[i] = new HashSet<Integer>();
            List<Integer> currw = wall.get(i);
            if(currw.size() > 1)
             all.add(currw.get(0));
             hsts[i].add(currw.get(0));
                
            for(int j=1;j<currw.size();j++){
               currw.set(j, currw.get(j-1)+currw.get(j));
                hsts[i].add(currw.get(j));
                if(j+1!=currw.size())
                all.add(currw.get(j));
            }
            maxs = Math.max(maxs, currw.size());
        }
        
        int i=0;
        int res = Integer.MAX_VALUE;
        for(int cv: all){
            // int cv = wall.get(0).get(v);
            int l =0;
            int tres =0;
            while(l<wall.size()){
            if(!hsts[l].contains(cv))
                tres++;
                l++;
                }
            // if(v +1 != wall.get(0).size()){
            res = Math.min(res, tres);
                
            // System.out.println(cv+" "+tres);
            // }
            
        }

        
        if(maxs == 1)
            return wall.size();
        return  res;
    }
}