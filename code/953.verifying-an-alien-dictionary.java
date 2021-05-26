class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        
        for(int i=0;i<words.length-1;i++){
            int nxt = i+1;
            int min = Math.min(words[i].length(), words[nxt].length());
            for(int k=0;k<min;k++){
                if(order.indexOf(words[i].charAt(k)) >  order.indexOf(words[nxt].charAt(k)))
                    return false;
                else if(order.indexOf(words[i].charAt(k)) <  order.indexOf(words[nxt].charAt(k)))
                        break;
                    else if(k == min-1 && words[i].length() > words[nxt].length() )
                    return false;
                
                    
            }
            
        }
        return true;
    }
}