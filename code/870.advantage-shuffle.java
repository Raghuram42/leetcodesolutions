class Solution {
    public boolean reorderedPowerOf2(int N) {
        int[][] mapr = new int[31][10];
        
        int p = 0;
        // System.out.println((1<<4));
        while(p<31){
            int val = (1<<p);
            // System.out.println(val+" "+p);
            while(val != 0){
                mapr[p][val%10]++;
                val= val/10;
            }
            
            p++;
        }
        
        
        
    p = 0;
        
        
        while(p<31){
            
            
            int val = N;
            
            while(val != 0){
                if(mapr[p][val%10] > 0)
                mapr[p][val%10]--;
                else 
                    break;
                val= val/10;
            }
            int check = p;
            int k= 0;
            while(k<10 && mapr[check][k] == 0)
                k++;
            if(k == 10 && val == 0)
                return true;
            p++;
        }
        
        return false;
    }
}