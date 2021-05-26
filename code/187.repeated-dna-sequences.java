class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> res = new HashSet<String>();
        HashSet<String> hst = new HashSet<String>();
        List<String> r = new ArrayList<String>();
        if(s.length() == 0)
            return r;
        for(int i=0;i<s.length()-9;i++){
            String saa = s.substring(i, i+10);
            if(hst.contains(saa))
                res.add(saa);
            else
                hst.add(saa);
                }
        
            for(String st: res)
                r.add(st);
        return  r;
    }
}