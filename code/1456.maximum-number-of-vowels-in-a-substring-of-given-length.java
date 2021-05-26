class Solution {
    public int maxVowels(String s, int k) {
        if(k>s.length())
            return 0;
        int[] mapr = new int[26];
        mapr['a'-'a'] = 1;
        mapr['e'-'a'] = 1;
        mapr['i'-'a'] = 1;
        mapr['o'-'a'] = 1;
        mapr['u'-'a'] = 1;
        int res = 0;
        for(int i=0;i<k;i++){
            if(mapr[s.charAt(i)-'a'] == 1)
                res++;
        }
       // System.out.println(s.length()+" "+k);
        if(k == s.length()){
            return res;
        }
        int maxv = -1;
        for(int i=k;i<s.length();i++){
            
            if(maxv < res)
                maxv = res;
            //System.out.println(res+" "+(i-k));
            if(mapr[s.charAt(i-k)-'a'] == 1){
                res = res - 1 <= 0 ? 0: res -1;
         //       System.out.println(res+" - "+(i-k) +" "+ s.charAt(i-k));
            }
            if(mapr[s.charAt(i)-'a'] == 1){
                res += 1;
           //     System.out.println(res+" + "+(i)+" "+s.charAt(i));
            }
        }
        return maxv > res ? maxv : res;
    }
}