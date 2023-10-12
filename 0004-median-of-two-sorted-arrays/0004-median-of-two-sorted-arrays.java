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
        return -1d;
    }
}