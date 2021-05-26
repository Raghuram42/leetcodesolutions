class Solution {
    public boolean validMountainArray(int[] A) {
        
        if(A.length <=2)
             return false;
        int hasdec = 0;
        
        for(int i =1;i<A.length;i++){
            if(A[i-1]>=A[i])
                hasdec += 1;
    
            if(hasdec >= 1 && A[i-1]<=A[i])
                return false;
        
        }
        return hasdec !=0 && hasdec!=A.length-1;
    }
}