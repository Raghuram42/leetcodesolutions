class Solution {
    public int numJewelsInStones(String J, String S) {
        int res = 0;
        for(int i=0;i<S.length();i++){
            for(int k=0;k<J.length();k++){
                if(S.charAt(i) == J.charAt(k))
                     res++;
            }
        }
        return res;
    }
}