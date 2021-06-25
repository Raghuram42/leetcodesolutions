class Solution {
    public void wiggleSort(int[] nums) {
        if(nums.length == 1)
            return;
        
        Arrays.sort(nums);
        
        int mid = nums.length%2 == 0 ? nums.length/2 :(nums.length/2)+1;
        
        
        if(nums[mid] == nums[mid-1])
            reverse(nums, 0, mid-1);
        
        // System.out.println(Arrays.toString(nums)+" "+mid);
        List<Integer> res = new ArrayList<>();
        int l =0;
        int r = nums.length-1;
        while(l<mid || r >= mid){
            if(l<mid)
                res.add(nums[l++]);
            
            if(r>=mid)
                res.add(nums[r--]);
                
        }
        
        int i =0;
        while(i<nums.length)
            nums[i] = res.get(i++);
        
        
    }
    public void reverse(int[] nums, int i, int j){
        int p = j/2;
        while(i<=p){
            int t = nums[i];
            nums[i] = nums[j];
            nums[j] = t;
            i++;
            j--;
        }
    }
}