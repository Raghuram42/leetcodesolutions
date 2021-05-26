class Solution {
    int[] parents;
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        parents= new int[n];
        
        Arrays.fill(parents, -1);
        
        
        for(int i=0;i<leftChild.length;i++){
            if(leftChild[i] != -1 )
            if(!union(i, leftChild[i]))
                return false;
                
            if(rightChild[i] != -1 )
            if(!union(i, rightChild[i]))
                return false;
        }
        
        int c = 0;
        for(int i=0;i<n;i++)
            if(parents[i] == -1)
                c++;
        return c == 1;
    }
    
    public boolean union(int i, int j){
        
        int p1 = find(i);
        int p2 = find(j);
        
        if(p1 == p2)
            return false;
        
        parents[p1] = p2;
        return true;
    }
    
    public int find(int i){
        if(parents[i] != -1){
            parents[i] = find(parents[i]);
            return parents[i];
        }
        
        return i;
    }
}