class Solution {
    public int bitwiseComplement(int N) {
       // System.out.println(~N);
        if(N == 0)
            return 1;
        int curr = N;
        int c = 0;
        while(curr != 0){
            c++;
            curr = curr >> 1;         
        }
        
        int num = (1 << c);
 //       System.out.println(num-1);
     return N^(num-1);   
    }
}