class Solution {
    HashSet<String> hst;
    int[] vis;
    public int numTilePossibilities(String tiles) {
        hst= new HashSet<>();
        vis = new int[tiles.length()];
        for(int i=0;i<tiles.length();i++)
        solve(tiles, i, new StringBuilder());
        return hst.size();
    }
    
    public void solve(String tiles, int i, StringBuilder curr){
        
        
        if(i == tiles.length()){
        if(curr.length() >0)
            curr.deleteCharAt(curr.length()-1);
            return;
        }
        
        vis[i] = 1;
        curr.append(tiles.charAt(i));
        hst.add(curr.toString());
        for(int j=0;j<tiles.length();j++){
            if(vis[j] != 1){
                // curr.append(tiles.charAt(j));
                solve(tiles, j, curr);
            }
            
        }
        vis[i] = 0;
        if(curr.length() >0)
            curr.deleteCharAt(curr.length()-1);
        
        return;
    }
}