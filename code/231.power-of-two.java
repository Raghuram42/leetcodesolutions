class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <=0)
            return false;
        int c = 0;
        while(n>0){
            n= n &(n-1);
            c++;
            if(c>1)
                return false;
        }
        return true;
    }
}