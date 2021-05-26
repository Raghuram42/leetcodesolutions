class Solution {
    public int maxSubarraySumCircular(int[] A) {
        
        int max_k = kadn(A);
        int max_sum = 0;
        for(int i=0;i<A.length;i++){
            max_sum += A[i];
            A[i] = -A[i];
        }
        max_sum = max_sum +kadn(A);
        if(max_sum ==0)
            return max_k;
        return max_sum >  max_k ? max_sum:max_k;
    }
    
    public int kadn(int[] a){
        int sum = 0;
        int max_sum = Integer.MIN_VALUE;
        
        for(int i=0;i<a.length;i++){
            sum += a[i];
                if(sum > max_sum)
                    max_sum = sum;
            if(sum < 0)
                sum = 0;
        }
        return max_sum;
    }
}