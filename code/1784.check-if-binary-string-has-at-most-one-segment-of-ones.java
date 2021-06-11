class Solution {
    public boolean checkOnesSegment(String s) {
     boolean ans = false;
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '1')
                ans =true;
            else if(ans){
                if(s.indexOf('1', i+1) != -1)
                return false;
                else
                    return true;
            }
        }
        
        return ans;
    }
}