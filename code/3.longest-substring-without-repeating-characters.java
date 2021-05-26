class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> hsp = new HashMap<Character, Integer>();
        String res = "";
        for(int st =0, end=0; end < s.length();end++){
            char curcr = s.charAt(end);
            
            if(hsp.containsKey(curcr)){
                st = Math.max(hsp.get(curcr)+1 ,st);
            }
            if(res.length()<end - st +1)
                 res = s.substring(st,end+1);        
            hsp.put(curcr, end);
        }
        if(res.length() == 0)
             return 0;
        return res.length();
    }
}