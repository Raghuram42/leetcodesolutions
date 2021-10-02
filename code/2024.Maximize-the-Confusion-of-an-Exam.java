class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        
        return Math.max(solve(answerKey, k, 'T'), solve(answerKey, k, 'F'));
    }
    public int solve(String answerKey, int k, char bol){
        Queue<Integer> q = new LinkedList<Integer>();
        int i = 0;
        int res  = 0;
        int n = answerKey.length();
        int ans = 0;
        while(k>0 && i < n){
            if(answerKey.charAt(i) != bol){
                q.offer(i);
                k--;
            }
    
            ans = i-1>= 0 ? ans+1 : 1;
            res = Math.max(res, ans);
            i++;
        }
        
        
        
        while(i<n && q.size() > 0){
            
            if(answerKey.charAt(i) != bol){
                
                int ky = q.poll();
                
                ans = i-ky;
                q.offer(i);
            }
            else
            ans = ans+1;
            res = Math.max(res, ans);
            i++;
        }
        
        // System.out.println(res+" "+bol+" "+q+" "+Arrays.toString(dp));
        return res;
    }
}
