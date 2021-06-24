/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        int n = grid.length;
        return solve(grid, 0, n, 0, n);
    }
    
    public Node solve(int[][] grid, int i, int imax, int j, int jmax){
 
        if(imax < i || jmax < j)
            return null;
        int[] tres = isEnd(grid, i, imax, j, jmax);
        if(tres[0] == 1)
            return new Node(tres[1] == 1, true);
        
        Node curr = new Node(true, false);
         // System.out.println(i+" "+imax+" "+j+" "+jmax);
        int inext = (i+imax);
        int jnext = j+jmax;
        curr.topLeft = solve(grid, i, (inext)/2, j, (jnext)/2);
        curr.topRight = solve(grid, i, inext/2, jnext/2, jmax);
        curr.bottomLeft = solve(grid, inext/2, imax, j, jnext/2);
        curr.bottomRight = solve(grid, inext/2, imax, jnext/2, jmax);
        
        return curr;
    }
    
    public int[] isEnd(int[][] grid, int i, int imax, int j, int jmax){
        
        int tar = grid[i][j];
        
        for(int p =i;p<imax;p++){
            for(int q =j;q<jmax;q++){
                if(tar != grid[p][q])
                    return new int[]{0, 1, 0};
            }
        }
        
        return new int[]{1, tar, 1};   
    }
}
/*
//
N = grid.length;

Node root = new Node(true, false);

return solve(root, 0, 0, 0, n-1, n-1, 0, n-1, n-1);
// return solve(root, 0, n-1);
//                    i   j
return solve(root, 0, n-1, 0, n-1);

solve(i, imax, j, jmax )
    if(!checkcanmove(grid, i, imax, j, jmax))
        return node(val, false);
  newnode = new node(1, false);
  newnode.tlft = solve(i, imax/2, j, jmax/2);
  tright = solve(i, imax/2, jmax/2, j);  
  bleft = solve(imax/2, imax, j, jmax/2);
  bright = solve(imax/2, imax, jmax/2, jmax);

return newnode;


  // bleft = solve(j/2, );
Node solve(Node root, int topl, int topr, int botleft, int botr){
    if(topr < topl || botr > botleft)
        return null;
    
    
    root.topLeft = solve(root);
    
    
}
*/