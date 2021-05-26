class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> hsm = new HashMap<Character, Integer>();
        
        hsm.put('I', 1);
        hsm.put('V', 5);
        hsm.put('X', 10);
        hsm.put('L', 50);
        hsm.put('C', 100);
        hsm.put('D', 500);
        hsm.put('M', 1000);
        int res = hsm.get(s.charAt(0));
        for(int i=1;i<s.length();i++){
            //System.out.println(hsm.get(s.charAt(i)) +" "+ hsm.get(s.charAt(i-1))+" "+res);
            if(hsm.get(s.charAt(i)) <= hsm.get(s.charAt(i-1)))
                res += hsm.get(s.charAt(i));
            else
                res = Math.abs(2*hsm.get(s.charAt(i-1)) - res - hsm.get(s.charAt(i)));
        }
        return res;
    }
}