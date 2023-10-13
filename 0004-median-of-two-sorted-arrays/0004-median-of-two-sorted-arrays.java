class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        
        int t = m+n;
        
        
        if((m+n)%2 == 1)
            return 0d+s(nums1, nums2, t/2, 0, m-1, 0, n-1);
        
        return (s(nums1, nums2, t/2, 0, m-1, 0, n-1)+s(nums1, nums2, (t/2)-1, 0, m-1, 0, n-1))/2d;
    }
    
    public int s(int[] n1, int[] n2, int k, int as, int ae, int bs, int be){
        if(as > ae)
            return n2[k-as];
        
        if(bs > be)
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