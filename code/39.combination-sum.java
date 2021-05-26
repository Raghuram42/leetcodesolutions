class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(candidates.length == 0)
            return res;
        
            solve(candidates, target, 0, 0, res, new ArrayList<Integer>());
 
        return res;
    }
    
    public List<List<Integer>> solve(int[] can, int target, int sum, int i, List<List<Integer>> res, ArrayList<Integer> curr){
       if(i>= can.length || sum > target)
           return res;
        
        if( target == sum){
            res.add(new ArrayList<Integer>(curr));
            return res;
        }
        //System.out.println(curr+" "+res+" before "+sum+" "+i);
            curr.add(can[i]);
            solve(can, target, sum+can[i], i, res, curr);
            curr.remove(curr.size()-1);
          //  System.out.println(curr+" "+res+" "+sum+" "+i);
            solve(can, target, sum, i+1, res, curr);
           // System.out.println(curr+" "+res+" aftr "+sum+" "+i);
            

        
        return res;
    }
}