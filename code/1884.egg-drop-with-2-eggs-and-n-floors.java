class Solution {
    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        return getVal(firstWord)+getVal(secondWord) == getVal(targetWord);
    }
    public int getVal(String firstWord ){
        int val = 0;
        for(int i=0;i<firstWord.length();i++){
            val = val*10;
            val += firstWord.charAt(i)-'a';
        }
        // System.out.println(val);
        return val;
    }
        
}