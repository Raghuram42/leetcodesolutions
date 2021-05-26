class Solution {
    public String interpret(String command) {
        StringBuilder str = new StringBuilder();
        StringBuilder res = new StringBuilder(); 
        for(int i=0;i<command.length();i++){
            str.append(command.charAt(i));
            if(str.toString().equals("G")){
                res.append(str.toString());
                str = new StringBuilder();
            }else if(str.toString().equals("()")){
                res.append("o");
                str = new StringBuilder();
            }else if(str.toString().equals("(al)")){
                res.append("al");
                str = new StringBuilder();
            }
            
        }
        return res.toString();
    }
}