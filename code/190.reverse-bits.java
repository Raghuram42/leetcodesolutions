public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
          String bitmask = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder();
        int len = bitmask.length();
        
        for(int i = len-1 ; i > -1; --i ){
            sb.append(bitmask.charAt(i));
        }
        while(len != 32){
            sb.append('0');
            ++len;
        }
        return Integer.parseUnsignedInt(sb.toString(), 2);
    }
}