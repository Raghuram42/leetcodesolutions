//2028. Find Missing Observations

class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = 0;
        for(int roll: rolls)
            sum += roll;
        
        int m = rolls.length;
        int left = (mean*(m+n))-sum;
        
        if(6*n < left || left < n)
            return new int[0];
        
        int[] res = new int[n];
        
        int same = left/n;
        for(int i=0;i<n;i++)
            res[i] = same;
        
         res[n-1] = left-(same*(n-1));
         n--;
        
        while(n >= 0 && res[n] > 6){
            res[n-1] += res[n]-6;
            res[n]     = 6;
            n--;
            }
        
        // = ;
        
        for(int s: res)
            sum += s;
        return res;
        
    }
}
