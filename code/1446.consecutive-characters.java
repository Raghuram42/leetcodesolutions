class Solution {
    public int maxPower(String s) {
        if(s.length() == 0)
            return 0;
        int m = 1;
        int max = 1;
        
        for(int i=1;i<s.length();i++){
            if(s.charAt(i-1) == s.charAt(i))
                m++;
            else
                m = 1;
            max = Math.max(max, m);
        }
        
        return max;
    }
}