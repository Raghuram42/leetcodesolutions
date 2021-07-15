class Solution {
    public String convertToBase7(int num) {
        StringBuilder res = new StringBuilder();
        boolean neg = false;
        if(num <0)
        {
            // res.append("-");
            neg = true;
            num = -num;
        }
        
        
        while(num>=7){
            int mod = num%7;
            res.append(mod);
            num = num/7;
        }
        
        res.append(num);
        
        if(neg)
            res.append("-");
        
        return res.reverse().toString();
    }
}
