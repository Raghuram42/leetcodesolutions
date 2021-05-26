class Solution {
    public String convert(String s, int numRows) {
        
        if(numRows == 1)
            return s;
        StringBuilder[] arry = new StringBuilder[numRows];
        
        for(int i=0;i<numRows;i++)
            arry[i] = new StringBuilder();
        
        
        int p =0;
        int f1 = 0;
        int l1 = 0;
        for(int i=0;i<s.length();i++){
            
            arry[p].append(s.charAt(i));
            //System.out.println(arry[p].toString()+" p "+p+" f1 "+f1+" l1 "+l1);
            if(p==0){
              f1 = 1;
              l1 =0;
            }
            else if(f1 == 1 && p == numRows-1 && l1 == 0){
                l1 = 1;
                f1 = 0;
            }
            
            if(f1 == 1)
                p++;
            else if(l1 == 1)
                p--;
        }
        
        StringBuilder res = new StringBuilder();
        for(int i=0;i<numRows;i++)
            res.append(arry[i]);
        
        return res.toString();
    }
}