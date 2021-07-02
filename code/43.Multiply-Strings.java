class Solution {
    int i;
    public String multiply(String num1, String num2) {
        i = 0;
        if(num2.equals("0") || num1.equals("0"))
            return "0";
        int p = num2.length()-1;
        List<Integer> bit = new ArrayList<>();
        while(p>=0)
            mult(num1, num2.charAt(p--)-'0', bit);
        
        StringBuilder res = new StringBuilder();
        
        
        p = bit.size()-1;
        
        while(p>=0)
            res.append(bit.get(p--));
        
        return res.toString();
    }
    
    public void mult(String num, int v, List<Integer> bit){
        int car = 0;
        int k =i;
        for(int p=num.length()-1;p>=0;p--){
            int val = ((num.charAt(p)-'0')*v)+car;
            if(bit.size() == k)
                bit.add(0);
            val =  bit.get(k)+val;
            bit.set(k, val%10);
            car = val/10;
            k++;
        }
        
        if(car>0){
            if(bit.size() == k)
                bit.add(0);
                bit.set(k, car);
        }
        i++;
    }
}
