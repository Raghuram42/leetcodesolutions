class Solution {
    public boolean checkRecord(String s) {
        int A = 0;
        int L = 0;
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'A')
                A++;
            else if(s.charAt(i) == 'L'){
                if(i-1  >= 0 && s.charAt(i-1) == 'L')
                    L++;
                else
                    L =1;
            }
            if(A >= 2 || L >= 3)
                return false;
        }
        return true;
    }
}