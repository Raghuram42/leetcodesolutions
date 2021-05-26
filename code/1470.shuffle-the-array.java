class Solution {
    public int[] shuffle(int[] nums, int n) {
        if(n>nums.length)
            n = nums.length%n;
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int j = n;
        for(int i=0;i<nums.length-n;i++){
            //System.out.println((i+1%2 == 0) +" " +(i+n-1 < nums.length));
         arr.add(nums[i]);
            arr.add(nums[i+j]);

        }
        int[] res= new int[arr.size()];
        
        for(int i=0;i<arr.size();i++){
            res[i] = arr.get(i);
        }
        return res;
    }
}