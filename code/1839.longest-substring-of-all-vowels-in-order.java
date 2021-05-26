class Solution {
    public int longestBeautifulSubstring(String word) {
        int st = 0;
        int end = 0;
        int res = 0;

        HashSet<Character> vwles = new HashSet<>();
        while(end<word.length()){
        
            if(end > 0 && word.charAt(end-1) > word.charAt(end)){
                    if(vwles.size() == 5){
                    res = Math.max(res, end-st);
                    }
                  st = end;
                  vwles = new HashSet<>(); 
            }
            
            vwles.add(word.charAt(end));
            end++;
            
        }
        return Math.max(res, vwles.size() == 5 ? end-st:0);
    }
}