class Solution {
    // List<String> res;
    public List<String> letterCombinations(String digits) {
        
        if(digits.length() == 0)
            return new ArrayList<>();
        String[] digitmapping = new String[10];
        // res = new ArrayList<>();
        
            digitmapping[2] = "abc";
            digitmapping[3] = "def";
        
            digitmapping[4] = "ghi";
        
            digitmapping[5] = "jkl";
        
            digitmapping[6] = "mno";
        
            digitmapping[7] = "pqrs";
            digitmapping[8] = "tuv";
            digitmapping[9] = "wxyz";
            
        
        
        
        List<String> res = new ArrayList<>();
        int p = 0;
        
        while(p<digitmapping[digits.charAt(0)-'0'].length())
        {
            res.add(""+digitmapping[digits.charAt(0)-'0'].charAt(p));
            p++;
        }
        
        for(int i=1;i<digits.length();i++){
            List<String> res2 = new ArrayList<>();
            int val = digits.charAt(i)-'0';
            
            String curr = digitmapping[val];
            int c=0;
            while(c<curr.length()){
                for(int l=0;l<res.size();l++)
                    res2.add(res.get(l)+""+curr.charAt(c));
                
                c++;
            }
            res = res2;
        }
        
        return res;
        
    }
    
    public void solve(String[] digitmapping, String digits, int i, int k, StringBuilder ans){
        
        if(i == digits.length()){
            // res.add((new StringBuilder(ans)).toString());
            return;
        }
        
        for(int j=i;j<digits.length();j++){
            int val = digits.charAt(j)-'0';
            for(int p=0;p<digitmapping[val].length();p++){
                ans.append(digitmapping[val].charAt(p));
                solve(digitmapping, digits, j+1, p, ans);
                ans.deleteCharAt(ans.length()-1);
            }
        }
    }
}