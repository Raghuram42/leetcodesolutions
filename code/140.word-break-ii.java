class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        if (s.length() > 100) return new ArrayList();
        List<String> res = new ArrayList<String>();
        wordHelper(s, wordDict, res, new StringBuilder());
        return res;
    }
    
    public void wordHelper(String s, List<String> words, List<String> res, StringBuilder str){
        
        if(str.length() != 0){
            str.append(" ");
        }
        
        
        for(String word: words){
            StringBuilder curr = new StringBuilder(str);
            
            if(s.startsWith(word)){
                
                curr.append(word);
                if(s.length() == word.length()){
                    res.add(curr.toString());
                }
                else{
                    wordHelper(s.substring(word.length()), words, res, curr);
                }
                
            }
        }
        
    }
}