class Solution {
    public int minTimeToType(String word) {
        // System.out.println(26-(int)('y'-'a'));
        
        
        return solve(word, 0, 0);
    }
    
    public int solve(String w, int i, int curr){
        if(i>=w.length())
            return 0;
        
        
        int clockCurrChar = Math.abs(curr-(int)(w.charAt(i)-'a'));
        int nextClockChar = 26-Math.abs(curr-(int)(w.charAt(i)-'a'));
        // System.out.println(clockCurrChar+" "+nextClockChar+" "+i +" "+(w.charAt(i)));
        
        return 1+Math.min(clockCurrChar, nextClockChar)+solve(w, i+1, (int)(w.charAt(i)-'a'));
        
    }
}
