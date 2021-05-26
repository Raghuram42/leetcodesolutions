class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        char[] inp = new char[1003];
        int p= 0;
        int c = 0;
        for(int i=0;i<word1.length;i++){
            for(int j=0;j<word1[i].length();j++){
                inp[p++] = word1[i].charAt(j);
                c++;
            }
        }
        p = 0;
        for(int i=0;i<word2.length;i++){
            for(int j=0;j<word2[i].length();j++){
                if(inp[p] != word2[i].charAt(j))
                    return false;
                p++;
            }
        }
        
        
        if(p != c)
            return false;
        return true;
    }
}