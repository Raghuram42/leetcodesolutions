class Solution {
    public int countPalindromicSubsequence(String s) {
        int[][] map = new int[26][2];
        for(int i=0;i<26;i++){
            map[i][0] = Integer.MAX_VALUE;
            map[i][1] = Integer.MIN_VALUE;
        }
        int n = s.length();
        for(int i=0;i<n;i++){
            map[s.charAt(i)-'a'][0] = Math.min(map[s.charAt(i)-'a'][0], i);
            map[s.charAt(i)-'a'][1] = Math.max(map[s.charAt(i)-'a'][1], i);
            }
        
        int res = 0;
        for(int i=0;i<26;i++)
            res += getAns(map, i, s);
        
        
        return res;
    }
    
    public int getAns(int[][] map, int i, String s){
        int st = map[i][0];
        int end = map[i][1];
        if(st == end || st == Integer.MAX_VALUE)
            return 0;
        // System.out.println(i+" "+st+" "+end);
        HashSet<Character> set = new HashSet<>();
        st++;
        // end--;
        while(st<end)
        {
            set.add(s.charAt(st));
            st++;
        }
        
        return set.size();
    }
}
