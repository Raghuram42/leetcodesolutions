class Solution {
    public String maximumOddBinaryNumber(String s) {
        int i = 0;
        int n = s.length();
        int c = 0;
        
        while(i<n){
            c += s.charAt(i++) == '1' ? 1 : 0;
        }
        StringBuilder str = new StringBuilder();
        while(c > 1){
            str.append(1);
            n--;
            c--;
        }
        
        while(n>1){
            str.append(0);
            n--;
        }
        
        str.append(1);
        
        return str.toString();
    }
}