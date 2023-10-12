class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int i = n-1;
        int carry = 0;
        digits[i]+=1;
        List<Integer> res = new ArrayList<>();
        while(i>=0){
            int val = digits[i]+carry;
            carry = val/10;
            res.add(val%10);
            i--;
        }
        
        if(carry > 0)
            res.add(carry);
        
        int[] ans = new int[res.size()];
        
        i = res.size()-1;
        
        int p = 0;
        while(i>=0){
            ans[p++] = res.get(i--);
        }
        return ans;
        
    }
}