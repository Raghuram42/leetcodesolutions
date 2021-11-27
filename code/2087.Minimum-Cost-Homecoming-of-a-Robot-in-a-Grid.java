class Solution {
    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        int min = Math.min(startPos[0], homePos[0])+1;
        int max = Math.max(startPos[0], homePos[0]);
        int res = 0;
        while(min < max)
            res += rowCosts[min++];
        
        
        
         min = Math.min(startPos[1], homePos[1])+1;
         max = Math.max(startPos[1], homePos[1]);
        
        
        while(min < max)
            res += colCosts[min++];
        
        return res + (startPos[0] != homePos[0] ? rowCosts[homePos[0]]: 0) + (startPos[1] != homePos[1] ? colCosts[homePos[1]]: 0);
        
    }
}
