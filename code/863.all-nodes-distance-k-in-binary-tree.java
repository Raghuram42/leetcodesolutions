class Solution {
    public boolean buddyStrings(String A, String B) {
        HashSet[] hsts = new HashSet[26];
        for(int i=0;i<26;i++)
            hsts[i] = new HashSet<Integer>();
        
        boolean gttwo =  false;
        for(int i=0;i<A.length();i++){
            hsts[A.charAt(i)-'a'].add(i);
            if(hsts[A.charAt(i)-'a'].size() > 1)
                gttwo = true;
        }
            if(A.equals(B))
                return gttwo;
        StringBuilder str = new StringBuilder();
        int ind1 = -1;
        int ind2 = -1;
             for(int i=0;i<B.length();i++){
                 if(hsts[B.charAt(i)-'a'].size() == 0)
                     return false;
                 else {
                     if(hsts[B.charAt(i)-'a'].contains(i))
                             hsts[B.charAt(i)-'a'].remove(i);
                     else{
                         str.append(B.charAt(i));
                         if(ind1 == -1)
                           ind1 = i;
                         else if (ind2 == -1)
                             ind2 = i; 
                         }
                 }
             }
     //   System.out.println(str.toString()+" "+ind1+" "+ind2);
        if(str.length() != 2)
            return false;
        if(A.charAt(ind1) == str.charAt(1) && A.charAt(ind2) == str.charAt(0))
            return true;
     return false;   
    }
}