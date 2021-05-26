class Solution {
    public int subtractProductAndSum(int n) {
        if(n == 0)
            return 0;
        int sum = 0;
        int pro = 1;
        
        while(n>0){
            int c = n%10;
            sum += c;
            pro *= c;
            n = n/10;
        }
        return pro-sum;
    }
}