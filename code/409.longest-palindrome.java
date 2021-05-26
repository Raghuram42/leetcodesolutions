class Solution {
    public int longestPalindrome(String s) {
        int[] mapr = new int[200];
    
        for(int i=0;i<s.length();i++)
            mapr[s.charAt(i)-'A']++;
        int j = 0;
        
        Arrays.sort(mapr);
        int at_end = 0;
        int res = 0;
        for(int i=mapr.length-1;i>=0;i--)
        {
            if(mapr[i]%2 == 0)
                res += mapr[i];
            else{
                at_end = 1;
                res += mapr[i]-1;
            }
        }
        
        return res+at_end;
    }
}