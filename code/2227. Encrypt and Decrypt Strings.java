class Encrypter {
    HashMap<Character, String> encr;
    HashMap<String, Integer> decr;
    HashMap<String, Integer> dic;
    String[] dictionary;
    public Encrypter(char[] keys, String[] values, String[] dictionary) {
        encr = new HashMap<>();
        decr = new HashMap<>();
        dic = new HashMap<>();
        int n = keys.length;
        for(int i=0;i<n;i++){
            encr.put(keys[i], values[i]);
            decr.put(values[i], decr.getOrDefault(values[i], 0)+1);
        }
        
        
        for(String s: dictionary){
            String curr = encrypt(s);
            dic.put(curr, dic.getOrDefault(curr, 0)+1);
        }
        
        
    }
    
    public String encrypt(String word1) {
        StringBuilder ans = new StringBuilder();
        int n = word1.length();
        for(int i=0;i<n;i++)
            ans.append(encr.get(word1.charAt(i)));
        
        return ans.toString();
    }
    
    public int decrypt(String word2) {
        return dic.containsKey(word2) ? dic.get(word2): 0;
    }
}

/**
 * Your Encrypter object will be instantiated and called as such:
 * Encrypter obj = new Encrypter(keys, values, dictionary);
 * String param_1 = obj.encrypt(word1);
 * int param_2 = obj.decrypt(word2);
 */
