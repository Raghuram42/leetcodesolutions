class Solution {
    public String getHint(String secret, String guess) {
        int ary[] = new int[10];
        int same = 0;
        int diff = 0;
        StringBuilder str = new StringBuilder();
        for(int i=0;i<secret.length();i++){
            if(secret.charAt(i) == guess.charAt(i)){
                same++;
            }else{
                ary[secret.charAt(i)-'0']++;
                str.append(guess.charAt(i));
            }
        }
        for(int i=0;i<str.length();i++){
            if(ary[str.charAt(i)-'0'] > 0){
                ary[str.charAt(i)-'0']--;
                diff++;
            }
        }
      
        return same+"A"+diff+"B";
    }
}