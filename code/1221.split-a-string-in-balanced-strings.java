class Solution {
    public int balancedStringSplit(String s) {
     int res = 0;
        if(s.length()==0)
            return res;
        int balancer = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'L')
                balancer++;
            else{
                balancer--;
            }
            if(balancer == 0)
                res++;
        }
        return res;
    }
}