class Solution {
    public List<Integer> grayCode(int n) {
       // if(n == 0)
       //     return  ArrayArrays.asList(0); //Arrays.asList({0});
        if(n == 1)
            return  new ArrayList<Integer>(Arrays.asList(0,1));
        
        List<Integer> seq = grayCode(n-1);
        
        int currNMax = 1<<(n-1);
        
        int sz = seq.size()-1;
        for(int i= sz;i>=0;i--){
            int val = (seq.get(i)+currNMax);
            seq.add(val);
        }
        
        return seq;
    }
}