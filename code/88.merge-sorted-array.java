class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        if(nums2.length == 0 || nums1.length == 0 || n==0)
            return;

        
        int i=m-1;
        int j=nums2.length-1;
        int itr = nums1.length-1;
     
        while(i>=0 && j>= 0) {
            
            if(nums1[i] >= nums2[j]){
                nums1[itr] = nums1[i];
                i--;
            }
            else{
                nums1[itr] = nums2[j];
                j--;
            }
            itr--;
        }
        while(i>=0){
                nums1[itr] = nums1[i];
                i--;
            itr--;
        }
        while(j>=0){
            
                nums1[itr] = nums2[j];
                j--;
            itr--;
        }
              
        
            
    }
}