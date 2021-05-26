class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i=0;i<nums.length;i++){
            // if(i == index[i])
            //     continue;
            
            res.add(index[i], nums[i]);
        }
        int[] res2 = new int[res.size()];
        int i=0;
        for(int n: res){
            res2[i] = n;
            i++;
        }
        return res2;
    }
}