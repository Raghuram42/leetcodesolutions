class Solution {
    public int reverse(int x) {
        int mod = 0;
        Long k = 0L;
        while (x != 0) {
            mod = x % 10;
            k = (k * 10) + mod;
            if (k > Integer.MAX_VALUE || k < Integer.MIN_VALUE) {
                return 0;
            }
            x = x / 10;
        }

        return k.intValue();
    }    
}