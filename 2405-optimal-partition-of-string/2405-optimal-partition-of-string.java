class Solution {
    public int partitionString(String s) {
        int[] map = new int[26];
        Arrays.fill(map, -1);
        int ans = 0;
        
        int i = 0;
        int n = s.length();
        int st = 0;
        while(i<n){
            int val = charToInt(s.charAt(i));
            int curr = map[val] < st ? -1: map[val];
            
            if(curr != -1){
                ans++;
                st = i;
            }
            map[val] = i;
            i++;
        }
        
        return ans+1;
    }
    
    public int charToInt(char c){
        return c-'a';
    }
}