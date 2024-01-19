class Solution {
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
    if(a == e && !(a == c && d > Math.min(b,f) && d < Math.max(b,f) )) return 1;
    if(b == f && !(b == d && c > Math.min(a,e) && c < Math.max(a,e) ))  return 1;
    if(c + d == e + f && !(c + d == a + b && a > Math.min(c , e) && a < Math.max(c, e) )) return 1;
    if(c-d == e-f && !( c-d == a-b && a > Math.min(c , e) && a < Math.max(c, e) )) return 1;
    return 2;
}
}