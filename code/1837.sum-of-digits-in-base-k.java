class Solution {
    public int sumBase(int n, int k) {
        // if(n == k)
        //     return getsum(n);
        
        n = Integer.parseInt(Integer.toString(n, k));
        System.out.println(n);
        return getsum(n);
    }
    
    public int getsum(int n){
        int s =0;
        
        while(n !=0 ){
            
            s += n%10;
            n=n/10;
        }
        return s;
    }
}