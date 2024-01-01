class Solution {
    
    class Pr{
        char c;
        int cost;
        
        Pr(char c, int cost){
            this.c = c;
            this.cost = cost;
        }
    }
    
    HashMap<Character, HashSet<Character>> g;
    long[][] map;
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        if(source.length() != target.length())
            return -1;
        g = new HashMap<>();
        
        int i = 0;
        int n = original.length;
        long[][] cmap = new long[26][26];
        map = new long[26][26];
        
        for(i=0;i<26;i++)
            Arrays.fill(cmap[i], Long.MAX_VALUE);
        for(i=0;i<n;i++)
        {
            cmap[original[i]-'a'][changed[i]-'a'] = Math.min(cmap[original[i]-'a'][changed[i]-'a'], cost[i]);
        }
        i = 0;
        while(i<n){
            
            if(!g.containsKey(original[i]))
                g.put(original[i], new HashSet<>());
            
            g.get(original[i]).add(changed[i]);
            i++;
        }
        
        
        long res = 0;
        
        for(i=0;i<source.length();i++){
            if(source.charAt(i) != target.charAt(i))
            {
                long currCost = d(source.charAt(i), target.charAt(i), cmap);
                if(currCost == Long.MAX_VALUE)
                    return -1;
                res += currCost;
            }
        }
        
        return res;
    }
    
    public long d(char s, char des, long[][] cmap){
        if(map[s-'a'][des-'a'] != 0)
            return map[s-'a'][des-'a'];
        long[] dis = new long[26];
        Arrays.fill(dis, Long.MAX_VALUE);
        PriorityQueue<Character> pq = new PriorityQueue<Character>(((a,b)->(int)(dis[a-'a']-dis[b-'a'])));
        
        dis[s-'a'] = 0;
        
        
        pq.offer(s);
        
        
        while(!pq.isEmpty()){
            char curr = pq.poll();
            
            for(char next: g.getOrDefault(curr, new HashSet<>())){
                long disUntilNext = dis[next-'a'];
                long newDisUntilNext = dis[curr-'a']+cmap[curr-'a'][next-'a'];
                
                if(disUntilNext > newDisUntilNext){
                    dis[next-'a'] = newDisUntilNext;
                    pq.offer(next);
                }
            }
        }
        map[s-'a'][des-'a'] = dis[des-'a'];
        return dis[des-'a'];
    }
}