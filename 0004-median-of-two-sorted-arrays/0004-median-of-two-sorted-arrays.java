class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        int mIndex = (m+n)%2 == 0 ? ((m+n)/2) : ((m+n)/2);
        boolean odd = ((m+n)%2) == 1;
        int lenC =0;
        int i = 0;
        int j = 0;
        
        int[] q = new int[2];
        int k = 0;
        while(i<m || j<n){
            
            if(i<m && j < n){
            if(nums1[i] <= nums2[j]){
                q[k%2] = nums1[i];
                i++;
                k++;
            }
            else{
                q[k%2] = nums2[j];
                k++;
                j++;
            }
            }
            else if(i<m){
                    q[k%2] = nums1[i];
                i++;
                k++;
                }else{
                    q[k%2] = nums2[j];
                k++;
                j++;
                }
            // System.out.println(odd+" "+Arrays.toString(q)+" "+mIndex+" "+lenC);
            if(lenC == mIndex){
                if(odd)
                    return (double)q[(k-1)%2];
                return (q[0]+0d+q[1])/2;
            }
            
            lenC++;   
        }
        int l=i;
        int r =j;
        if(l<m){
            l = r == 0 ? mIndex : mIndex-r;
            
            if(odd)
                return (double)nums1[l];
            return (nums1[l]+nums1[l-1])/2d;
            
        }
        
        
        if(r < m){
            r = l == 0 ? mIndex : mIndex-l;
            
            if(odd)
                return 0d+nums2[r];
            return (nums2[r]+nums2[r+1])/2d;
        }
        
        return -1d;
    }
}