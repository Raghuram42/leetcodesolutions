class Solution {
    List<Integer> res;
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        res = new ArrayList<>();
        HashSet<Integer> hst = new HashSet<>();
        for(int i=0;(int)Math.pow(x, i)<=bound;i++){
            for(int j=0;(int)Math.pow(y, j)+(int)Math.pow(x, i)<=bound;j++){
                if(!hst.contains((int)Math.pow(x, i)+(int)Math.pow(y, j))){
                res.add((int)Math.pow(x, i)+(int)Math.pow(y, j));
                    hst.add((int)Math.pow(x, i)+(int)Math.pow(y, j));
                    // System.out.println(i+" "+j);
                }else if(y== 1)
                    break;
            }
            if(x == 1)
                break;
        }
        // solve(x, y, 0 ,0 , bound);
        // System.out.println((3<<1));
        return res;
    }
    
    
    public void solve(int x, int y, int i, int j, int bound){
        int currval = 1;
        if(i==0 && j == 0)
            currval = 2;
        else if(i==0)
            currval = y+1;
        else if(j==0)
            currval = x+1;
        else{
            currval = x+y;

            }
        if(currval > bound)
            return;
        System.out.println(x+" "+y+" "+i+" "+j);   
        res.add(currval);
        
        solve(x, (int)Math.pow(y, j+1), i, j+1, bound);
        solve((int)Math.pow(x, i+1), y, i+1, j, bound);
      
        
    }
}