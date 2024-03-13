class Solution {
    public int pivotInteger(int n) {
        int total = (n*(n+1))/2;
        
        int i = 1;
        
        int sum = 0;
        while(i<=n){
            
            sum += i;
            
            if(sum == total-sum+i)
                return i;
            i++;
        }
        
        
        return -1;
        
    }
}