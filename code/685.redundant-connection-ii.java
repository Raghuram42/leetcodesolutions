class Solution {
public int[] findRedundantDirectedConnection(int[][] edges) {
int N = edges.length;
int[] in_degree = new int[N+1];

    //Build the adjacency matrix
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for(int[] edge : edges){
        int start = edge[0];
        int end = edge[1];
        in_degree[end]++;
        if(!map.containsKey(start)) map.put(start, new HashSet<>());
        map.get(start).add(end);
    }
    
    //for every edge, delete it and see if there is a loop. if there is no a loop and all the nodes can be traverse, return the edge
    for(int i=N-1; i>=0; i--){
        int start = edges[i][0];
        int end = edges[i][1];
        in_degree[end]--;
        map.get(start).remove(end);
        for(int j=1; j<=N; j++){
            if(in_degree[j] == 0){
                Set<Integer> visited = new HashSet<>();
                if(dfs(map, j, visited) && visited.size() == N) return edges[i];
                break;
            }
        }
        map.get(start).add(end);
        in_degree[end]++;
    }
    return null;
}

//if there is a loop
public boolean dfs(Map<Integer, Set<Integer>> map, int start, Set<Integer> visited){
    if(visited.contains(start)) return false;
    visited.add(start);
    Set<Integer> neighbors = map.get(start);
    if(neighbors != null){
        for(int neighbor : neighbors){
            if(!dfs(map, neighbor, visited)) return false;
        }
    }
    return true;
}

}