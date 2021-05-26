class Solution {
    public int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        
        Arrays.fill(primes, true);
        for(int i=2;i*i<n;i++){
            if(primes[i]){
                for(int p=i*i;p<n;p+=i){
                    primes[p] = false;
                }
            }
        }
        
        int res = 0;
        for(int i=2;i<n;i++)
            if(primes[i])
                res++;
        return res;
    }
}