class Solution {
    public int hammingDistance(int x, int y) {
        
        //System.out.print
        int n =  (x | y) & ~(x & y) ;
          int count = 0; 
        while (n > 0) { 
            n &= (n - 1); 
            count++; 
        } 
        return count; 
    }
}