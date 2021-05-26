class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        ArrayList<Integer> diff = new ArrayList<Integer>();
        
        for(int i=1;i<A.length;i++)
            diff.add(A[i]-A[i-1]);
        // System.out.println(diff);
        int res = 0;
        int curres = 0;
        for(int i=1;i<diff.size();i++){
            if(diff.get(i)==diff.get(i-1))
                curres++;
            else{
                res += (curres)*(curres+1)/2;
                curres = 0;
            }
        }
        if(curres != 0)
            res += (curres)*(curres+1)/2;
        
        return res;
        
    }
}