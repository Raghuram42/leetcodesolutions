class Solution {
    public String toLowerCase(String str) {
        StringBuilder lo = new StringBuilder();
        
        for(int i=0;i<str.length();i++){
            int c = str.charAt(i);
            if(c>= 65 && c<= 90)
                c = c+32;
            lo.append((char)c);
        }
        return lo.toString();
    }
}