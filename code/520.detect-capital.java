class Solution {
    public boolean detectCapitalUse(String word) {
        
        int caps = 0;
        int small = 0;
        char[] c = word.toCharArray();
        int f = 0;
        for(int i=0;i<c.length;i++){
            if(Character.isDigit(c[i]))
                return false;
            if(i ==0 && c[i]==Character.toUpperCase(c[i]))
                 f = 1;
            if(c[i] ==  Character.toUpperCase(c[i]))
                caps++;
            else if(c[i] ==  Character.toLowerCase(c[i]))
                small++;
        }
        return caps == word.length() || small == word.length() || (f == 1 && small == word.length()-1)? true:false;
//         if(word.equals(word.toUpperCase()))
//             return true;
//         else if(word.equals(word.toLowerCase()))
//             return true;
//         else if(word.equals(Character.toUpperCase(word.charAt(0))+word.substring(1)))
//                 return true;
                
//                 return false;
    }
}