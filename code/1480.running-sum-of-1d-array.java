class Solution {
    public int kthFactor(int n, int k) {
        if(k>n)
            return -1;
        
        int c = 0;
        for(int i=1;i<=n;i++){
            if(n%i == 0){
                c++;
                if(c == k)
                    return i;
            }
        }
        
        return -1;
    }
}