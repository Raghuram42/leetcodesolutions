class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(n==0)
            return tasks.length;
        int[] mpr = new int[26];
        
        int max_c = 0;
        int no_max_c = 0;
        int min_c = Integer.MAX_VALUE;
        int no_min_c = 0;
        for(char task: tasks){
            mpr[task-'A']++;
            
            if(max_c < mpr[task-'A']){
                max_c = mpr[task-'A'];
                no_max_c = 1;
            }
            else if(max_c == mpr[task-'A'])
                 no_max_c++;
            
            
            
             if(min_c > mpr[task-'A']){
                min_c = mpr[task-'A'];
                no_min_c = 1;
            }
            else if(min_c == mpr[task-'A'])
                 no_min_c++;
        }
     return Math.max(tasks.length, (max_c-1)*(n+1) + no_max_c);   
    }
}