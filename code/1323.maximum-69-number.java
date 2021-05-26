class Solution {
    public int maximum69Number (int num) {
        int i = -1;
        int cnt = 0;
        int c = num;
        while(c > 0){
          
            if(c%10 == 6)
                i = cnt;
            c = c/10; 
              cnt++;
        }
       // System.out.println(Math.pow(10,i));
        return num + 3 * (int)(Math.pow(10,i));
    }
}