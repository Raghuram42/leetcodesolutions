class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        p(s, 0, new ArrayList<String>());
        return res;
    }
    
    public void p(String s, int i, List<String> r){
        if(i>= s.length()){
            res.add(new ArrayList<String>(r));
            return;
        }
        
        int n = s.length();
        for(int l=i+1;l<=n;l++){
            String first = s.substring(i, l);
            if(pal(first)){    
                r.add(first);
                p(s, l, r);
                r.remove(r.size()-1);
            }
        }
    }
    
    public boolean pal(String s){
        int l = 0;
        int r = s.length()-1;
        
        while(l<=r){
            if(s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        
        return true;
    }
}