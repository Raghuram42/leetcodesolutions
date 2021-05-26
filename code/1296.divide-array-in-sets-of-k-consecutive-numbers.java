class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        if(nums.length % k != 0)
            return false;
        Arrays.sort(nums);
        HashMap<Integer, Integer> hsm = new HashMap<Integer, Integer>();
        
        for(int num:nums)
            hsm.put(num, hsm.getOrDefault(num, 0)+1);
      
        
        for(int num:nums){
            if(hsm.get(num) > 0){
                int curr = num;
                int c_k = k;
                while(c_k >0 && hsm.containsKey(curr) && hsm.get(curr) > 0){
              //      System.out.println(c_k+" "+curr+" "+(hsm.get(curr)-1));
                    c_k--;
                    hsm.put(curr, hsm.get(curr)-1);
                    curr++;
                }
           //   System.out.println(hsm);
                if(c_k > 0){
                    curr = num-1;
                while(c_k >0 &&  hsm.containsKey(curr) && hsm.get(curr) > 0){
             //       System.out.println(c_k+" - "+curr);
                    c_k--;
                    hsm.put(curr, hsm.get(curr)-1);
                    curr--;
                }
                    if(c_k !=0)
                        return false;
                }
            }
        }
        
        return true;
    }
}