class Solution {
    public double findMedianSortedArrays(int[] A, int[] B) {
       int na = A.length, nb = B.length;
        int n = na + nb;
        if ((na + nb) % 2 == 1) {
            return s(A, B, n / 2, 0, na - 1, 0, nb - 1);
        } else {
            return (double)(s(A, B, n / 2, 0, na - 1, 0, nb - 1) + s(A, B, n / 2 - 1, 0, na - 1, 0, nb - 1)) / 2;
        }
    }
    
    
    public int s(int[] n1, int[] n2, int k, int as, int ae, int bs, int be){
        if( ae< as)
            return n2[k-as];
        
        if(be < bs)
            return n1[k-bs];
        
        int aI = (as+ae)/2;
        int bI = (bs+be)/2;
        
        if(aI+bI < k){
        if(n1[aI] > n2[bI])
            return s(n1, n2, k, as, ae, bI+1, be);
        else {
                return s(n1, n2, k, aI + 1, ae, bs, be);
            }
        }else{
        if(n1[aI] > n2[bI])
            return s(n1, n2, k, as, aI-1, bs, be);
         else {
                return s(n1, n2, k, as, ae, bs, bI - 1);       
            }
        }
    }
}
/*
    
     public int s(int[] n1, int[] n2, int k, int as, int ae, int bs, int be) {
     
        if (ae < as) {
            return n2[k - as];
        }
        if (be < bs) {
            return n1[k - bs];
        }
        
       
        int aI = (as + ae) / 2, bI = (bs + be) / 2;
        int aValue = n1[aI], bValue = n2[bI];
        
        // If k is in the right half of A + B, remove the smaller left half.
        if (aI + bI < k) { 
            if (aValue > bValue) {
                return s(n1, n2, k, as, ae, bI + 1, be);
            } else {
                return s(n1, n2, k, aI + 1, ae, bs, be);
            }
        }
        // Otherwise, remove the larger right half. 
        else { 
            if (aValue > bValue) {
                return s(n1, n2, k, as, aI - 1, bs, be);
            } else {
                return s(n1, n2, k, as, ae, bs, bI - 1);       
            }
 }
*/