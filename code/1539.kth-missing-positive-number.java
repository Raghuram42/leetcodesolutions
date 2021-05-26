class Solution {
    public int findKthPositive(int[] arr, int k) {
        int p = 1;
        
        for(int i=0;i<arr.length;i++){
            
            while(p != arr[i]){
          
                k--;
                if(k == 0)
                    return p;
                p++;
            }
            p++;
        }
        
        return p+k-1;
    }
}