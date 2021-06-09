class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int st=0;
        int i=0;
        
        int sum = 0;
        int maxsum = 0;
        int[] map = new int[10001];
        Arrays.fill(map, -1);
        while(i<nums.length){
            if(map[nums[i]] != -1){
                while(st<map[nums[i]])
                    sum -= nums[st++];
            }
            sum += nums[i];
            maxsum = Math.max(sum, maxsum);
            map[nums[i]] = i+1;
            i++;
        }
        return maxsum;
    }
}
/*
//[4,2,4,5,6]
map 0 1 2 3 4 5 6
        2   1 4 5
    st
    sum -? 2+4
    max = 6
st = 0;
i =0;
max = 0;
i<len
if(map[nums[i]] != -1){
while(st<map[nums[i]]){
sum -= nums[st];
st++;
}
sum += nums[i];
max = Math.max(sum, max);
map[nums[i]] = i+1;
i++;
}
*/