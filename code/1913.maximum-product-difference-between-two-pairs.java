class Solution {
    public String largestOddNumber(String num) {
        int i = num.length()-1;
        
        while(i>=0){
            if((num.charAt(i)-'0')%2 == 1)
                break;
            i--;
        }
        
        return num.substring(0, i+1);
    }
}