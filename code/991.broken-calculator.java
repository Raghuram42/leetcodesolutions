class Solution {
    public int brokenCalc(int X, int Y) {
        if(X >= Y)
            return X-Y;
        
        int res= 1;
        if(Y%2 == 1){
            res = 2;
            Y = Y+1;
        }
        
        return res+brokenCalc(X,Y/2);
    }
    
}