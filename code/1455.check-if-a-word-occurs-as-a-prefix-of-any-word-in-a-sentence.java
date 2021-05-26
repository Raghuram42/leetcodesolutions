class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] arr = sentence.split(" ");
        int c = 0;
        for(String a : arr){
           System.out.println(a.indexOf(searchWord));
            int p = a.indexOf(searchWord); 
            if(p == 0)
                return c+1;
            c++;
        }
        return -1;
    }
    }