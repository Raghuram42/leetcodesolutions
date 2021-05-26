class Solution {
    public int sumOfUnique(int[] nums) {
        int[] mapr = new int[101];
        int sum = 0;
        for(int num: nums) 
            mapr[num]++;
        
        
        for(int i=0;i<101;i++)
                     if(mapr[i] == 1)
                sum += i;
        return sum;
    }
}