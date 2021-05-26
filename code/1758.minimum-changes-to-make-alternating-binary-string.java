class Solution {
    public int minOperations(String s) {
        // StringBuilder pos1 = new StringBuilder();
        
        int matchz1 = 0;
        int match1z = 0;
        for(int i=0;i+1<s.length();i=i+2){
            // if(i+1 < s.length())
            String curr = s.charAt(i)+""+s.charAt(i+1); 
            if(curr.equals("01"))
                match1z = match1z+2;
            else
            if(curr.equals("00") || curr.equals("11"))
                match1z++;
                
        }
        if(s.length()%2 == 1 && s.charAt(s.length()-1) == '0')
            match1z++;
            
        for(int i=0;i+1<s.length();i=i+2){
            // if(i+1 < s.length())
            String curr = s.charAt(i)+""+s.charAt(i+1); 
            if(curr.equals("10"))
                matchz1 = matchz1+2;
            else
            if(curr.equals("00") || curr.equals("11"))
                matchz1++;
                
        }
        // System.out.println(match1z+" "+ matchz1);
        if(s.length()%2 == 1 && s.charAt(s.length()-1) == '1')
            matchz1++;
        // if(s.length()%2 == 0)
            return Math.min(match1z, matchz1);
    }
}