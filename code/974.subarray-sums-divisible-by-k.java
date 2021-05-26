class Solution {
    public int subarraysDivByK(int[] A, int K) {
        int sum = 0;
        int c = 0;
        int[] ary = new int[K];
        ary[0] =1;
        for(int i=0;i<A.length;i++){
            sum += A[i];
            
            sum = sum % K;
            if(sum <0)
                sum = sum+K;
            c += ary[sum];
            ary[sum]++;
        }
        return c;
    }
} 