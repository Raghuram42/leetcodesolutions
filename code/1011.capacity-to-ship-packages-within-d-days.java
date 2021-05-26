class Solution {
    public int shipWithinDays(int[] weights, int D) {
    int max = 0;
        int sum =0;
        
        for(int i:weights){
            max = Math.max(i, max);
            sum+=i;
        }
        
        
        int left = max;
        int right = sum;
        
        
        while(left < right){
            int mid = (left+right)/2;
            
            if(getDays(weights, mid) > D) left = mid+1;
            else
                right = mid;
        }
        
        return left;
    }
    
    public int getDays(int[] weights, int target){
        
        int st = 0;
        int noofdays= 1;
        for(int i:weights){
            if(st+i>target){
                st=0;
                noofdays++;
            }
            st+=i;
        }
        
        return noofdays;
    }
}