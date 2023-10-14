class Solution {
    String[] inp;
    List<String> res;
    public List<String> letterCombinations(String digits) {
        
        inp = new String[]{"0","0","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        res = new ArrayList<>();
        if(digits.length() == 0){
            return res;
        }
        solve(digits, 0, "");
        return res;
    }
    
    public void solve(String d, int i, String s){
        if(i>=d.length()){
            res.add(s);
            return;
        }
        
        String curr = inp[d.charAt(i)-'0'];
        
        for(int j=0;j<curr.length();j++)
            solve(d, i+1, s+curr.charAt(j));
        
    }
}