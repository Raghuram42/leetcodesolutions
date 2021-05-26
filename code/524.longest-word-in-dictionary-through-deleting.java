class Solution {
    public String findLongestWord(String s, List<String> d) {
        int[] mapr = new int[26];
        Arrays.fill(mapr, -1);
        for(int i=0;i<s.length();i++)
            if(mapr[s.charAt(i)-'a'] == -1)
                mapr[s.charAt(i)-'a'] = i;
        String res = "";
        for(String str : d){
            
            int i = 0;
            int j = 0;
            while(i<str.length() && j < s.length()){
                if(mapr[str.charAt(i)-'a'] == -1)
                    break;
                // else if(j < mapr[str.charAt(i)-'a']){
                //     j = mapr[str.charAt(i)-'a']+1;
                //     i++;
                // }
                else if(str.charAt(i) == s.charAt(j)){
                    i++;
                    j++;
                }
                else
                    j++;
                
                
            }
            
            if(i == str.length() && res.length() <= str.length()){
                if((res.length() == str.length() && str.compareTo(res) < 0) || res.length() < str.length())
                    res = str;
                
            }
            
        }
        // System.out.println("b".compareTo("c"));
        return res;
    }
}