class Solution {
    public int countBalls(int lowLimit, int highLimit) {
        int[] mapr = new int[100001];
        
        int ans  = 0;
        for(int i=lowLimit;i<=highLimit;i++){
            int ind = getSumValue(i);
            mapr[ind]++;
        ans = Math.max(ans, mapr[ind]);
        }
        
        return ans;
        
    }
    public int getSumValue(int i){
        int sum = 0;
        while(i != 0){
            sum += i%10;
            i=i/10;
        }
        return sum;
    }
}