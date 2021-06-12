class Solution {
    public int chalkReplacer(int[] chalk, int k) {
     long sum = 0;
        
        for(int i=0;i<chalk.length;i++)
            sum += chalk[i];
        
        // System.out.println(sum);
        k = (int)((k*1l)%sum);
        
        for(int i=0;i<chalk.length;i++){
            if(k<chalk[i])
                return i;
            k -= chalk[i];
        }
        return -1;
        
    }
}