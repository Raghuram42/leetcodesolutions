class WordFilter {
    HashMap<String, Integer>  hsm;
    public WordFilter(String[] words) {
        hsm = new HashMap<>();
        
        for(int i=0;i<words.length;i++){
            String curr = words[i];
            
            
            String[] prefixs = new String[curr.length()];
            String[] suffis = new String[curr.length()];
            String pr="";
            String suf ="";
            for(int j=0;j<curr.length();j++){
              pr = pr+curr.charAt(j);  
              suf = suf+curr.charAt(curr.length()-j-1);  
              prefixs[j] = pr;
              suffis[j] = suf;  
            }
            
            for(int j=0;j<curr.length();j++){
                for(int k=0;k<curr.length();k++){
                    String key = prefixs[j]+"#"+suffis[k];
                    hsm.put(key, i);
                }
            }
        }
        
    }
    
    public int f(String prefix, String suffix) {
        
        suffix = prefix+"#"+(new StringBuilder(suffix)).reverse().toString();
        
        return hsm.containsKey(suffix)?hsm.get(suffix):-1;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
//apple , applllee
//