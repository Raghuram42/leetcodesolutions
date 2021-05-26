class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
       
        res = new ArrayList<List<String>>();
        
        solve(s, new ArrayList<String>());
        return res;
    }
    
    public void solve(String s, List<String> tempres){
      if(s.length() == 0)
          res.add(new ArrayList<String>(tempres));
        
        
        for(int i=0;i<s.length();i++){
            String curr = s.substring(0, i+1);
            if(isValidPalindrome(curr)){
                tempres.add(curr);
                solve(s.substring(i+1), tempres);
                tempres.remove(tempres.size()-1);
            }
            
        }
    }
    
    public boolean isValidPalindrome(String s){
        boolean isap = true;
        int i=0;
        int lmt = s.length()%2 == 0? s.length()/2 : (s.length()/2)+1;
        while(i<lmt){
            if(s.charAt(i) != s.charAt(s.length()-1-i))
                return false;
            i++;
        }
        
        return isap;
        
    }
}