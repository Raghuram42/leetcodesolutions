
class Solution { 

    public boolean isIsomorphic(String s, String t){
        return same(generalize(s), generalize(t));
}

public String generalize(String s ){
    int st = 1;
    int i = 0;
    StringBuilder res = new StringBuilder();
    int n = s.length();
    int[] map = new int[256];
    while(i < n) {
        int currst = map[s.charAt(i)];
        if(currst == 0){
            map[s.charAt(i)] = st;
            currst = st;
        }
            
        int freq = 1; 
        while(i+1<n && s.charAt(i) == s.charAt(i+1))
        {
            i++;
            freq++;
        }
    res.append(currst);
    res.append("$");
    res.append(freq);

    if(freq == 1)
        i++;
    st++;
    }
    // System.out.println(s+" "+res.toString());
    return res.toString();
}

public boolean same(String s, String t){
    return s.equals(t);
}

}
