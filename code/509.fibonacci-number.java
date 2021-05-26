class Solution {
    int[] mapr = new int[40];
    
    public int fib(int n) {
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        if(mapr[n] != 0)
            return mapr[n];
        return mapr[n] = fib(n-1) + fib(n-2);
            
    }
}