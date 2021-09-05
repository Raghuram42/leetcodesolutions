class Solution {
    public int countQuadruplets(int[] nums) {
        HashSet<String> set = new HashSet<>();
        
        System.out.println(Arrays.toString(nums));
        int n = nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    for(int l=k+1;l<n;l++)
                        if(nums[i]+nums[j]+nums[k] == nums[l])
                            set.add(i+" "+j+" "+" "+k+" "+l);
                }
            }
        }
        
        return set.size();
    }
}
