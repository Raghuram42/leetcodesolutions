class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1)
            return strs[0];
        if(strs.length == 0)
            return "";
        HashSet<String> hs = new HashSet<String>();
        for(int i=1;i<strs[0].length();i++){
            hs.add(strs[0].substring(0,i));
        }
        String sub = "";
        for(int i=0;i<=strs[0].length();i++){
           if(strs[1].length() >= i && strs[0].substring(0,i).equals(strs[1].substring(0,i))){
           //    System.out.println(strs[0].substring(0,i)+"in "+strs[1].substring(0,i)+" "+i);
               sub = strs[0].substring(0,i);
           }
                    
        }
        
        //System.out.println(sub);
        int maxl = sub.length();
        for(int i=2;i<strs.length;i++){
            if(strs[i].length() >= maxl  && sub.substring(0, maxl).equals(strs[i].substring(0, maxl))){
                continue;
            }
            else if(maxl-1 >= 0){
                maxl--;
                i--;
            }
        }
        return sub.substring(0,maxl);
//         for(int i=1;i<strs[0].length();i++){
//             hs.add(strs[0].substring(0,i));
//         }
        
//         for(int i=1;i<strs.length;i++){
//             for(int j=1;i<strs[i].length();j++){
//             if(hs.contains(strs[i].substring(0,j)))
//             {
//                 sub = strs[i].substring(0,j);
//             }
//                 else{
//                     return "";
//                 }
//                 }
//         }
//         return sub;
    }
}