class NumArray {
    int[] copy;
    int[] nums;
    public NumArray(int[] nums) {
        int n = nums.length;
        this.nums= nums;
        copy = new int[n+1];
        int i = 0;
        for(int num: nums){
            nums[i] = 0;
            update(i, num);
            nums[i] = num;
            i++;
        }
    }
    
    public void update(int index, int val) {
        int n = copy.length;
        index++;
        int p = index-1;
        while(index < n){
            copy[index] = copy[index]+val-nums[p];
            index += index & -index;
        }
        nums[p] = val;
                // System.out.println(Arrays.toString(nums)+" "+Arrays.toString(copy));

    }
    public int sum(int i){
        int sum = 0;
        while(i > 0){
            sum += copy[i];
            i -= i&-i;
        }
        return sum;
    }
    public int sumRange(int left, int right) {
        // System.out.println(Arrays.toString(nums)+" "+Arrays.toString(copy));

        return sum(right+1)-sum(left);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */