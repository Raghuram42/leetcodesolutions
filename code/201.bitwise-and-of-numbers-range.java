class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if(m == 0 || n == 0)
              return 0;
                                                                                                                            if(((int)(Math.log(m) /  Math.log(2) + 1)) != ((int)(Math.log(n) /  Math.log(2) + 1)) )
                                                                                                                                return 0;
                 int c = 0;                                                                                                           while(m!=n){
                                                                                                                                m >>=1;
                                                                                                                                    n>>=1;
                                                                                                                                c++;
                                                                                                                            }
        return m<<c;
    }
}