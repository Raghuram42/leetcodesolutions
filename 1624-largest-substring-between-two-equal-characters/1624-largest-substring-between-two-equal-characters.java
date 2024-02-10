class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int[] map = new int[26];
        
        int i = 0;
        int n = s.length();
        Arrays.fill(map, -1);
        int ans = -1;
        for(i=0;i<n;i++)
        {
            int k = s.charAt(i)-'a';
            if(map[k] == -1)
                map[k] = i;
            else{
                ans = Math.max(ans, i-map[k]-1);
            }
        }   
        return ans;
    }
}