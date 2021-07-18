class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] word = text.split(" ");
        int[] map = new int[26];
        int res = 0;
            for(int j=0;j<brokenLetters.length();j++)
                map[brokenLetters.charAt(j)-'a']++;
                
        for(int i=0;i<word.length;i++)
        {
            boolean notPresent = true;
            for(int j=0;j<word[i].length();j++){
                if(map[word[i].charAt(j)-'a'] > 0){
                    notPresent = false;
                    break;
                }
            }
            if(notPresent)
                res++;
        }
            
        return res;
    }
}
