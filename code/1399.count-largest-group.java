class Solution {
    public int countLargestGroup(int n) {
        int[] mapr = new int[1001];
        int max = -1;
        for(int i=1;i<=n;i++){
            int p = i;
            int sum = 0;
            while(p!=0){
                sum += p%10;
                p=p/10;
            }
              mapr[sum]++;
            max = Math.max(max, mapr[sum]);

        }
        int res = 0;
        for(int i=1;i<=1000;i++)
            res += mapr[i] == max ? 1 : 0;
        return res;
     }
}