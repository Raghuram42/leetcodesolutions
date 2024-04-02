class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        if(s.length() == 0)
            return 0;
        String[] ar = s.split(" ");
        return ar[ar.length-1].length();
    }
}