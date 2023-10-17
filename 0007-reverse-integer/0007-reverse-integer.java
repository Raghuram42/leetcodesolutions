class Solution {
    public int reverse(int x) {
        int revnum =0;
        int sign = revnum < 0 ? -1 : 1;
        while(x != 0){
            if(revnum > Integer.MAX_VALUE/10)
                return 0;
            
            if(revnum < Integer.MIN_VALUE/10)
                return 0;
            
            revnum = revnum*10 + x%10;
            x = x/10;
            
        }
        // System.out.println(Integer.MAX_VALUE);
        return revnum*sign;
    }
}