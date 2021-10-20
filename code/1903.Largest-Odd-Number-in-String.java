class Solution {
    public String largestOddNumber(String num) {
        int ind = -1;
        int n = num.length();
        
        for(int i=0;i<n;i++){
            if((num.charAt(i)-'0')%2 == 1)
                ind = i;
        }
        
        return ind == -1 ? "" : num.substring(0, ind+1);
    }
}
