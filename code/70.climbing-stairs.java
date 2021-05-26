class Solution {
    public int climbStairs(int n) {
        int a = 1;
        int b = 2;
        
        while(n-2>0){
            a += b;
            b += a;
            n = n-2;
        }
        
      //  System.out.println(n+" "+a+" "+b);
        return n==2 ? b: a;
    }
}