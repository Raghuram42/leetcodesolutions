class Solution {
public:
    typedef pair<int,int> pp;
    int networkDelayTime(vector<vector<int>>& times, int n, int k) {
        int res=0;
        vector<pp> adj[n+1];
        for(auto x:times)
        {
            adj[x[0]].push_back(make_pair(x[1],x[2]));
        }
        vector<int> dis(n+1,INT_MAX);
        dis[k]=0;
        priority_queue<pp,vector<pp>,greater<pp>> pq;
        pq.push(make_pair(dis[k],k));
        while(!pq.empty())
        {
            pp tmp=pq.top();
            pq.pop();
            int node=tmp.second;
            for(auto ch:adj[node])
            {
                int chnode=ch.first;
                int chwt=ch.second;
                if(dis[chnode]>dis[node]+chwt)
                {
                    dis[chnode]=dis[node]+chwt;
                    pq.push(make_pair(dis[chnode],chnode));
                }
            }
        }
        for(int i=1;i<=n;i++)
        {
            if(dis[i]==INT_MAX)
                return -1;
            res=max(res,dis[i]);
        }
        return res;
    }
};
// class Solution {
//     int[] allnodecosts;
//     HashMap<Integer, List<Integer>> graph;
//     int[][] costs;
//     public int networkDelayTime(int[][] times, int n, int k) {
//         allnodecosts = new int[n+1];
//         costs = new int[n+1][n+1];
//         Arrays.fill(allnodecosts, Integer.MAX_VALUE);
//         graph = new HashMap<>();
        
//         for(int[] time: times){
//             if(!graph.containsKey(time[0]))
//                 graph.put(time[0], new ArrayList<Integer>());
            
//             graph.get(time[0]).add(time[1]);
//             costs[time[0]][time[1]] = time[2];
//         }
        
//         allnodecosts[k] = 0;
//         dfs(k, 0);
//         int res = 0;
//         for(int i=1;i<=n;i++){
//             // System.out.println(i+" "+allnodecosts[i]);
//             // if(allnodecosts[i] == k)
//             //     continue;
//             if(allnodecosts[i] == Integer.MAX_VALUE)
//                 return -1;
//         else
//             res = Math.max(res, allnodecosts[i]);
//         }
//         return res;
        
//     }
//     class Pair{
//         int p1;
//         int p2;
//         Pair(int p1, int p2){
//             this.p1 = p1;
//             this.p2 = p2;
//         }
        
//         @Override
//         public String toString(){
//             return this.p1+" "+this.p2;
//         }
        
//     }
    
//     public void dfs(int i, int parent){
        
        
            
//         if(parent != 0){
            
//         if(allnodecosts[i] < allnodecosts[parent]+costs[parent][i])
//         {
//             allnodecosts[i] = Math.min(allnodecosts[parent]+costs[parent][i], allnodecosts[i]);
//             return;
//         }
//         }
        
        
//         if(!graph.containsKey(i))
//             return;
 
        
//         for(int ch: graph.get(i)){
//             if(ch != i)
//                 dfs(ch, i);
//         }
//         return;
//     }
// }