class Solution {
    public boolean wordPattern(String pattern, String str) {
            String[] mapr = new String[26];
            String[] arr = str.split(" ");
        
        for(int i=0;i<26;i++)
            mapr[i] = "";
        
        if(pattern.length() != arr.length)
            return false;
        for(int i=0;i<pattern.length();i++){
         //   System.out.println(pattern.charAt(i) +" "+arr[i]+" "+mapr[pattern.charAt(i)-'a']);
            if(mapr[pattern.charAt(i)-'a'].length() == 0)
            mapr[pattern.charAt(i)-'a'] = arr[i];
            else if(!mapr[pattern.charAt(i)-'a'].equals(arr[i]))
                return false;
        }
        String prev = mapr[0];
        HashSet<String> hst = new HashSet<String>();
         for(int i=0;i<26;i++)
         {
             if(mapr[i].length() > 0 && hst.contains(mapr[i]))
                 return false;
             hst.add(mapr[i]);
         }
        return true;
          
    }
}