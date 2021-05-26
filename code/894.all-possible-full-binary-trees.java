class Solution {
    public String decodeAtIndex(String s, int K) {
        // char[] mapr = new char[101];
        TreeMap<Long, Character> hsm = new TreeMap<Long, Character>();
        long p = 1;
        // int prev
        for(int i=0;i<s.length();i++){
            // Lonf key = p;
            if(s.charAt(i)-'0' >= 2 && s.charAt(i)-'0' <= 9 )
                p =  (p-1)*((s.charAt(i)-'0'));
            
            hsm.put(p, s.charAt(i));
            p++;
        }
        long key = K*1l;
        
        
        
        return solve(hsm, key);
    }
    
    public String solve(TreeMap<Long, Character> hsm, long key){
        
        // if
            long fl =hsm.floorKey(key);
            long c = key%fl;
        
        c = c == 0? fl : c;
            while(!hsm.containsKey(c) || hsm.get(c) >= '2' && hsm.get(c)<= '9'){
                if(hsm.containsKey(c))
                c = hsm.floorKey(c-1);
                else{
                    fl =hsm.floorKey(c);
                    c = c%fl;
                    c = c == 0? fl:c;
                }
            }
        
        return hsm.get(c)+"";    
        
        
    }
}