class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
     Arrays.sort(tokens);
      int i = 0;
      int l = tokens.length-1;
        int score = 0;
        int maxscore = 0;
        while(i<=l){
    //        System.out.println(tokens[i]+" "+score+" "+l);
            if(tokens[i] <= P){
                score++;
                P -= tokens[i];
            } 
            else if(tokens[l] > P && score >= 1 && i != l){
                P += tokens[l];
                l--;
                score--;
                continue;
            }
            maxscore = Math.max(maxscore, score);
            i++;
        }
        return maxscore;
    }
}