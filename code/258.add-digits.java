class Solution {
    public int addDigits(int num) {
        int res = 0;
        while(num != 0){
            res += num%10;
            if(num/10 == 0 && res > 9){
                num = res;
                res = 0;
                continue;
            }
            num = num/10;
        }
        
        return res;
    }
}