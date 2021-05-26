class Solution {
    public int minOperations(int n) {

        int minop = 0;
        for(int i=0;i<n/2;i++)
            minop += (n-(2*i)-1);
        
        return minop;
    }
}