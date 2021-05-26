class Solution {
    public String restoreString(String s, int[] indices) {
        StringBuilder str = new StringBuilder();
        char[] arry = new char[s.length()];
        for(int i=0;i<s.length();i++){
          arry[indices[i]] = s.charAt(i);
        }
        for(char  c: arry)
            str.append(c);
        return str.toString();
    }
}