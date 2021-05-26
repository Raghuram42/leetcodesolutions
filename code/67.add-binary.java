class Solution {
    public String addBinary(String a, String b) {
        StringBuilder str = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        char carr = 0;
    
        while(i >= 0  && j >= 0 ){
            int curr = valOf(a.charAt(i))+valOf(b.charAt(j))+carr;
       //     System.out.println(curr);
            if(curr == 1){
                str.append('1');
                carr = 0;
            }
            else if(curr == 2){
                str.append('0');
                carr = 1;
            }
            else if(curr == 3){
                str.append('1');
                carr = 1;
            }
            else if(carr == 1){
                str.append('1');
                curr = 0;
            }
            else{
                str.append('0');
            }
                
            j--;
            i--;
    }
        
        while(i >= 0){
               int curr = valOf(a.charAt(i))+(int)carr;
            if(curr == 1){
                str.append('1');
                carr = 0;
            }
            else if(curr == 2){
                str.append('0');
                carr = 1;
            }
            else if(curr == 3){
                str.append('1');
                carr = 1;
            }
            else if(carr == 1){
                str.append('1');
                curr = 0;
            }
            else{
                str.append('0');
            }
            i--;
        }
        
        while(j >= 0){
                int curr = valOf(b.charAt(j))+(int)carr;
            if(curr == 1){
                str.append('1');
                carr = 0;
            }
            else if(curr == 2){
                str.append('0');
                carr = 1;
            }
            else if(curr == 3){
                str.append('1');
                carr = 1;
            }
            else if(carr == 1){
                str.append('1');
                curr = 0;
            }
            else{
                str.append('0');
            }

            j--;
        }
        if(carr == 1)
            str.append('1');
        
        return str.reverse().toString();
    }
    public int valOf(Character c){
        if(c == '1')
            return 1;
        return 0;
    }
}