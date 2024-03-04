class Solution {
    Integer[][] dp;
    public int bagOfTokensScore(int[] tokens, int power) {

        
        Arrays.sort(tokens);
        
        int l = 0;
        int r = tokens.length-1;
        int sc = 0;
        int maxSc = 0;
        while(l<=r){
            if(power >= tokens[l])
            {
                sc++;
                power -= tokens[l];
                l++;
            }else if(sc > 0){
                power += tokens[r];
                sc--;
                r--;
            }else{
                l++;
            }
            maxSc = Math.max(maxSc, sc);
        }
        return maxSc;
    }
}