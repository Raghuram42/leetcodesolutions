class Solution {

    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for(int match: matchsticks)
            sum += match;
        
        if(sum%4 != 0)
            return false;
        
        int target = sum/4;

        return solve(matchsticks, 0, new int[4],target );
    }

public boolean solve(int[] match, int i, int[] square, int target){
    if(i == match.length)
        return true;
    
    for(int s=0;s<4;s++){
        if(square[s]+match[i] <= target){
            square[s] += match[i];
            if(solve(match, i+1, square, target))
                return true;
                 square[s] -= match[i];
            
        }
        
    }
    return false;
    
}
}
/*
// [5, 5, 5, 5, 4 ,4 ,4 ,4 ,3 ,3 ,3 ,3] -> 12
map t  12       t           t
[3,3,3,3,4] 4
 0
 1 -2 -2 -2 -3
 
*/