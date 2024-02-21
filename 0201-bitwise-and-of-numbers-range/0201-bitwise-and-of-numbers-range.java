class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int pL = pow(left);
        int rL = pow(right);
        if(left == right)
            return left;
        
        if(pL != rL)
            return 0;
        int ans = 0;
        while(left != right){
            left = left >> 1;
            right = right >> 1;
            ans++;
        }
        // System.out.printl(left);
        return (left<<ans);
        
    }
    
    public int pow(int v){
        if(v == 0)
            return 0;
        int i = 0;
        
        while((1<<i) <= v && i < 32)
            i++;
        
        return (1 << i-1);
    }
}