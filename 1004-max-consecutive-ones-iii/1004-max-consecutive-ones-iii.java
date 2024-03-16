class Solution {
    public int longestOnes(int[] nums, int k) {
        int ans = 0;
        int i = 0;
        int n = nums.length;
        
        int tans = 0;
        int st = 0;
        int p = k;
        while(i<n){
            tans += nums[i];
            
            if(k >0 && nums[i] == 0){
                tans +=1;
                k--;
            }else if(p >0 && k == 0 && nums[i] == 0){
                
                while(st < i && k == 0){
                    tans--;
                    if(nums[st] == 0)
                        k++;
                    st++;
                }
                
                if(k>0){
                tans++;
                k--;
                }
            }else if(nums[i] == 0){
                st = i+1;
                tans = 0;
            }
            
            ans = Math.max(ans, tans);
            i++;
        }
        
        return ans;
    }
}

