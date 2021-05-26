class Solution {
    int[] trifib = new int[38];
    public int tribonacci(int n) {
       if(n == 0) 
           return 0;
        if(n<=2)
            return 1;
        if(trifib[n] != 0)
            return trifib[n];
        return trifib[n] = tribonacci(n-1)+tribonacci(n-2)+tribonacci(n-3);
    }
}