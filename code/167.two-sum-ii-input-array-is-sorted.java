class Solution {
    public int compareVersion(String version1, String version2) {
     if(version1.length() == 0 && version2.length() == 0)   
         return 0;
        
        String[] f = version1.replace("."," ").split(" ");
        String[] s = version2.replace("."," ").split(" ");
        int l = 0;
        int r = 0;
        int max = Math.max(f.length, s.length);
        //    System.out.println(f.length+" "+s.length);
        while(l<f.length || r < s.length){
            String v1 = "0";
            String v2 = "0";
            
            if(l<f.length){
                v1 = f[l];
                    
            l++;
            }
            
            if(r<s.length){
                v2 = s[r];
                r++;
            }
            int a = Integer.parseInt(v1);
            int b = Integer.parseInt(v2);
       //    System.out.println(a+" "+b);
            if(a == b)
                max--;
            else if(a < b)
                return -1;
            else if(a > b)
                return 1;
           
        }
        if(max == 0)
            return 0;
        return 1;
    }
}