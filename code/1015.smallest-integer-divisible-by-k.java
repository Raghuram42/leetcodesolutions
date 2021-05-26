class Solution {
    public int smallestRepunitDivByK(int K) {
     if(K%2 == 0 || K%5 == 0)
         return -1;
        long num = 0;
        int ans = 0;
        while(ans <= K){
            num = ((num*10) +1)%K;
            // num += 1;
            ans++;
            if(num == 0)
                return ans;
        }
        return -1;
    }
}