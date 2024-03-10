class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] map = new int[1001];
        
        for(int i=0;i<nums1.length;i++)
            if(map[nums1[i]] == 0)
            map[nums1[i]]++;
        
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i=0;i<nums2.length;i++)
            if(map[nums2[i]] == 1){
              map[nums2[i]]++;
                res.add(nums2[i]);
            }
        
        int[]  ans = new int[res.size()];
        int i = 0;
        for(int a: res)
            ans[i++]=a;
        return ans;
    }
}