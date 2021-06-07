class Solution {
    public int numDifferentIntegers(String word) {
        int res = 0;
        
        HashSet<String> set = new HashSet<>();
        int i =0;
        
        while(i<word.length()){
            if(Character.isDigit(word.charAt(i))){
                // res++;
                
                while(i<word.length() && word.charAt(i) == '0')
                    i++;
                int p = i;
                while(p<word.length() && Character.isDigit(word.charAt(p)))
                    p++;
                String no =word.substring(i,p);
                if(!set.contains(no)){
                    set.add(no);
                    res++;
                }
                i=p;
            }else
            i++;
        }
        
        return res;
    }
}