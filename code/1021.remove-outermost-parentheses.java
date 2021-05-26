class Solution {
 public String removeOuterParentheses(String S) {
        char[] chars = S.toCharArray();
        StringBuilder result = new StringBuilder();

        int i = 0;
        int openCount = 0;

        while (i < chars.length){
            if ('(' == chars[i]){
                openCount ++;
            }
            if (openCount > 1){
                result.append(chars[i]);
            }
            if (')' == chars[i]){
                openCount --;
            }
            i ++;
        }
        return result.toString();
    }
}