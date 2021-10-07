class Solution {
    public int minimumBoxes(int n) {
        int ans1 = 0;
        int ans2 = 0;
        
        long curr = 0;
        
        while(curr+((ans1+1)*1l*(ans1+2))/2 <= n){
            curr += ((ans1+1)*1l*(ans1+2))/2;
            ans1++;
        }
        
        
        while(curr < n){
            ans2++;
            curr += ans2;
        }
            
        return ((ans1*(ans1+1))/2)+ans2;
    }
}
