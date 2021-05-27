class Solution {
    public String sortSentence(String s) {
        HashMap<Integer, String> hsm = new HashMap<>();
        
        String[] sts = s.split(" ");
        
        for(int i=0;i<sts.length;i++){
            hsm.put(sts[i].charAt(sts[i].length()-1)-'0', sts[i].substring(0, sts[i].length()-1));
        }
        
        StringBuilder str = new StringBuilder();
        for(int i=1;i<=hsm.size();i++){
            str.append(hsm.get(i));
            if(i!=hsm.size())
                str.append(" ");
        }
        
        return str.toString();
    }
}