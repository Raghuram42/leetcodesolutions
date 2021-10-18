class Solution {
    public boolean areNumbersAscending(String s) {
        int prev = -1;
        int n = s.length();
        for(int i=0;i<n;){
            if(Character.isDigit(s.charAt(i)))
            {
                
                int val = 0;
                while(i< n && Character.isDigit(s.charAt(i)))
                {
                    val = val*10+ (s.charAt(i)-'0');
                    i++;
                }
                if(prev >= val)
                    return false;
                prev = val;
                // System.out.println(prev);
            }else i++;
        }
        
        return true;
    }
}
