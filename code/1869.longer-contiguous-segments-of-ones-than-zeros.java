class Solution {
    public int minSwaps(String s) {
        if(s.length() == 1)
            return 0;
        int ones = 0;
        
        for(int i=0;i<s.length();i++){
            ones += s.charAt(i) == '1' ? 1: 0;
        }
        
        if((ones-1 != s.length()-ones && ones+1 != s.length()-ones && ones != s.length()-ones))
            return -1;
        
        int zeros = s.length()-ones;
        StringBuilder firstones = new StringBuilder();
        StringBuilder firstzeros = new StringBuilder();
        
        for(int i=0;i<s.length();i++){
            if(i%2 == 0){
            firstones.append("1");
            ones--;
            zeros--;    
            firstzeros.append("0");
            }else{
            firstones.append("0");
            firstzeros.append("1");
            }
        }
        if(ones < 0)
            return solve(s,firstzeros.toString());
        if(zeros < 0)
            return solve(s,firstones.toString() );
        // System.out.println(firstones.toString()+" "+firstzeros.toString());
        return Math.min(solve(s,firstones.toString() ), solve(s,firstzeros.toString()) );
        
    }
    
    public int solve(String s, String target){
        
        int res = 0;
        int ones = 0;
        for(int i=0;i<s.length();i++){
            res += s.charAt(i) != target.charAt(i) ? 1: 0;
        }
        
        return res/2;
    }
}