class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        digits[digits.length-1] +=1;
        for(int i=digits.length-1;i>=0;i--){
            int plusone = digits[i]+carry;
            if(plusone > 9)
                carry = plusone/10;
            else
                carry = 0;
            digits[i] = plusone%10;
            if(carry == 0)
                break;
        }
        if(carry !=0 ){
            digits = Arrays.copyOf(digits, digits.length + 1);
            digits[0] = carry;
        }
        return digits;
    }
}