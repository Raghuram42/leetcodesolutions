class Solution {
    public String getSmallestString(int n, int k) {
       
        char[] charary = new char[n];
        int p = n-1;
        while(p>=0){
            charary[p] = 'a';
            k--;
            p--;
        }
        
        p = n-1;
        
        while(k>=26 && p >= 0){
            charary[p] = 'z';
            k -=25;
            p--;
        }
        // System.out.println(k);
        if(k>0 && p >=0)
             charary[p] = (char)(k+'a');
//         while(n > 0){
//             if(k/n <= 26 && n != 1){
//                 str.append('a');
//                 k = k-1;
//                 n--;
//             }
//             else{
//                  str.deleteCharAt(str.length() - 1);
//                 // k =k+1;
//                 str.append((char)((k%26)+'a'));
//                 k = k-(k%26);
//                 while(k>0 && n>0){
//                     str.append('z');
//                     k = k/26;
//                     n--;
//                 }
//                 break;
//             }
            
//             // n--;
//         }
        
        return String.valueOf(charary);
    
    }
}