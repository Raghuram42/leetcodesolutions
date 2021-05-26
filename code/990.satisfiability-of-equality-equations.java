class Solution {
    int[] parents;
    int[] sz;
    public boolean equationsPossible(String[] equations) {
        parents = new int[26];
        sz = new int[26];
        for(int i=0;i<26;i++){
            parents[i] = i;
            sz[i] = 1;
        }
        for(int i=0; i<equations.length;i++){
            String s = equations[i];
            if(s.charAt(1) == '!')
                continue;
            union(s.charAt(0)-'a',s.charAt(3)-'a');
        }
        
                for(int i=0; i<equations.length;i++){
            String s = equations[i];
            if(s.charAt(1) == '=')
                continue;
                    // System.out.println(parents[s.charAt(0)-'a'] +" "+parents[s.charAt(3)-'a']);
         int p1 = find(s.charAt(0)-'a');
        int p2 = find(s.charAt(3)-'a');
          if(p1 == p2)
              return false;
        }
        
        return true;
    }
    
    public void union(int i, int j){
        int p1 = find(i);
        int p2 = find(j);
        
        if(p1 == p2){
          return;
        }
        
        if(sz[p1] > sz[p2]){
            parents[p2] = p1;
            sz[p1]++;
        }else{
            parents[p1] = p2;
            sz[p2]++;
        }
        
       // return true;
    }
    
    public int find(int i){
     if(parents[i] != i)
         parents[i] = find(parents[i]);
        
        return parents[i];
    }
}