class Solution {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> hst = new HashSet<String>();
        
        for(String email : emails){
            StringBuilder str = new StringBuilder();
            int cantake = 1;
            for(int i=0;i<email.length();i++){
                // System.out.println(email.charAt(i)+" "+cantake);
                if(email.charAt(i) == '@'){
                    // str.append(email.charAt(i));
                    cantake = 2;
                }
                if(cantake == 2 || (email.charAt(i) != '.' && email.charAt(i) != '+' && cantake == 1)){
                    str.append(email.charAt(i));
                    
                }else if(email.charAt(i) == '+')
                    cantake = 0;
            }
            hst.add(str.toString());
        }
        // System.out.println(hst);
        return hst.size();
    }
}