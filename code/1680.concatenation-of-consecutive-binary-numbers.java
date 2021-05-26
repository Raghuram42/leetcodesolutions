class Solution {
    int[] dp;
    int p;
    public int concatenatedBinary(int n) {
        dp = new int[10001];
        p = -1;
        long ans = 0;
        for(int i=1;i<=n;i++){
            int tmp =countbits(i);
            // System.out.println(tmp +" "+n+" "+i+" "+p);
            ans = mod((ans << tmp) + i);
        }
        
        return (int)ans;
    }
    
    public int countbits(int n){
        if(n == 0)
            return 0;

        return 1+countbits(n/2);
    }
    
    public int mod(long n){
        return (int)(n%1000000007);
    }
}