class Solution {
    public String intToRoman(int num) {
        
        HashMap<Integer, String> hsm = new HashMap<>();
        
        
        hsm.put(1, "I");
        hsm.put(4, "IV");
        hsm.put(5, "V");
        hsm.put(9, "IX");
        hsm.put(10, "X");
        hsm.put(40, "XL");
        hsm.put(50, "L");
        hsm.put(90, "XC");
        hsm.put(100, "C");
        hsm.put(400, "CD");
        hsm.put(500, "D");
        hsm.put(900, "CM");
        hsm.put(1000, "M");
        
        StringBuilder res = new StringBuilder();
        while(num > 0){
            
            if(hsm.containsKey(num))
            {
                res.append(hsm.get(num));
                num = 0;
            }
        else{
            int p = getnearnum(num );
            // System.out.println(p);
                res.append(hsm.get(p));
                num = num-p;
        }
        }
        return res.toString();
    }
    
    public int getnearnum(int num){
     if(num >= 1 && num <=3)
         return 1;
        
        if(num >= 4 && num < 5)
         return 4;
        
        if(num >= 5 && num < 9)
            return 5;
        
        if(num == 9)
            return 9;
        
        if(num >= 10 && num < 40)
            return 10;
        
        if(num >= 40 && num <= 49)
            return 40;
        
        if(num > 49 && num < 90)
            return 50;
        
        if(num >= 90 && num< 100)
            return 90;
        
        if(num >= 100 && num < 400)
            return 100;
        
        if(num >= 400 && num < 500)
            return 400;
        
        if(num >= 500 && num < 900)
            return 500;
        if(num >= 900 && num < 1000)
            return 900;
        
        return 1000;
        
        
        
    }
    
}