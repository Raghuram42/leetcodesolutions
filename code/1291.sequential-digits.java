class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        String l = low+"";
        String h = high+"";
       // System.out.println(l+" "+h);
        List<Integer> res = new ArrayList<Integer>();
        int i = 1;
        int j= h.length();
        int p = 0;
        System.out.println(i);
       while(i<=9){
        p = calcv(low, high, i, i, res, 0, 1);
        i++;
        }
        //calcv(low, high, 6, 6, res, 0, 1);
        Collections.sort(res);
        return res;
    }
    
    public int calcv(int low, int high, int i, int st, List<Integer> res, int val, int thou){
       if(val > high || i > 10){
      //     System.out.println(val+" "+st+" "+thou);   
        return val%10;
       }
      // System.out.println(val+" "+st+" ");
       if(val >= low && val <= high)
           res.add(val);
        
        
       val = val*10+i;
       thou = 10*thou;
        
        if(val > high){
            return val%10;
        }
        return calcv(low,high,i+1, st, res,val,thou);
       //calcv(low, high,st+1, st+1, res, 0, 1);
    }
}