class Solution {
    public int totalFruit(int[] tree) {
        int sz = 2;
        HashMap<Integer, Integer> lsm = new HashMap<Integer, Integer>();
        Queue<Integer> q = new LinkedList<Integer>();
        int ans = 0;
        for(int tr: tree){
            lsm.put(tr, lsm.getOrDefault(tr, 0)+1);
            q.offer(tr);
            Set<Integer> ky = lsm.keySet();
            
                    while(lsm.size() >2){
                        int curr = q.poll();
                        if(lsm.get(curr) == 1)
                        {
                            lsm.remove(curr);
                            break;
                        }else
                            lsm.put(curr, lsm.get(curr)-1);
                    }
                
                int tres = 0;
                for(int k:ky){
                    tres += lsm.get(k);
                }
                ans = Math.max(ans, tres);
        }
        return ans;
    }
}