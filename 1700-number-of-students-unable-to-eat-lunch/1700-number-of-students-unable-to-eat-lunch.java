class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int onesS = 0;
        int sandS = 0;
       
        Queue<Integer> stk = new LinkedList<>();
        
        for(int s: students)
            stk.offer(s);
        int i = 0;
        int sz = stk.size();
        int p = 0;
        while(!stk.isEmpty()){
            
            if(stk.peek() == sandwiches[i]){
                stk.poll();
                i++;
                p = 0;
            }else{
                  if(p == stk.size())
                    return stk.size();
                p++;
                stk.offer(stk.poll());
            }   
        }
        
    return 0;
    }
}

/*


[1,1,1] 
[0,1,1]

*/