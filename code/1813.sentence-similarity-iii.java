class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        // sentence1 = sentence1.toLowerCase();
        // sentence2 = sentence2.toLowerCase();
        if(sentence1.length() < sentence2.length())
            return areSentencesSimilar(sentence2, sentence1);
        
        String s1[] = sentence1.split(" ");
        String s2[] = sentence2.split(" ");
        int i = 0;
        int j = 0;
        int used = 0;
        
        
        while(i<s1.length && j<s2.length){
            
            if(s1[i].equals(s2[j])){
                i++;
                j++;
                if(used == 1)
                    used = 2;
            }else{
                i++;
                if(used <= 1)
                used = 1;
                else
                     break;
            }   
        }
        
    if(i == s1.length && j == s2.length || used == 0)
        return true;
        
        i = s1.length-1;
        used = 0;
        j = s2.length-1;
        while(i>=0 && j>=0){
            
            if(s1[i].equals(s2[j])){
                i--;
                j--;
                if(used == 1)
                    used = 2;
            }else{
                i--;
                if(used <= 1)
                used = 1;
                else
                     return false;
            }   
        }
        
        
        
    return i < 0 && j <0 || used == 0;
        
    }
}
//Input: sentence1 = "My name is Haley", sentence2 = "My Haley"
//