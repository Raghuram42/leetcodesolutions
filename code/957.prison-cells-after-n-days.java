class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        // if(N>cells.length)
        if(N>14)
        N = (N)%14;
        if(N%14 == 0)
            N= 14;
        int[] res = new int[cells.length];
        if(cells.length == 0)
            return cells;
       while(N>0){
        for(int i=1;i<cells.length-1;i++){
            if(cells[i-1] == cells[i+1])
                res[i] = 1;
            else
                res[i] = 0;
        }
      //     System.out.println(Arrays.toString(res));
      cells = res.clone();
          N--;
       }
     return cells;   
    }
}