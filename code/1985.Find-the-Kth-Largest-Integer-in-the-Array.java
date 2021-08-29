class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        int n = nums.length;
        k = n-k;
        
        Arrays.sort(nums, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                if(a.length() == b.length())
                    return a.compareTo(b);
                return a.length()-b.length();
            }
        });
        // System.out.println(Arrays.toString(nums));
        return nums[k];
    }
}
