class Solution {
    public boolean isIdealPermutation(int[] A) {
        
        int glob = 0;
        int loc = 0;
        int n = A.length;
        for(int i=1;i<n;i++)
            if(A[i-1] > A[i])
                loc++;
            
                for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
                if(A[i] > A[j])
                    glob++;
            }
                    if(glob > loc)
                        return false;
                }
        
        return glob == loc;
    }
}