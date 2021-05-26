class Solution {
    public boolean isPalindrome(int x) {
        if( x < 0)
            return false;
        int len = String.valueOf(x).length();
        
        int rev = 0;
        int c = 0;
        while(x != 0 && len/2 != c ){
            rev = rev * 10 + x%10;
            x = x/10;
            c++;
        }
     //   System.out.println(rev+" "+x);
        return len%2 == 0 ? rev == x : rev == x/10;
    }
}