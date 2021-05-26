class Solution {
    public List<String> letterCasePermutation(String S) {
        Queue<StringBuilder> que = new LinkedList<StringBuilder>();
        que.offer(new StringBuilder());
        for(int i=0;i<S.length();i++){
            char curr = S.charAt(i);
        
                int sz = que.size();
                
                while(sz>0){
                    StringBuilder currstr = que.poll();
                if(Character.isDigit(curr)){
                    currstr.append(curr);
                    que.offer(currstr);
                }
                else {
                    // System.out.println(currstr.toString());
                      que.offer(new StringBuilder(currstr).append(Character.toLowerCase(curr)));
                     currstr.append(Character.toUpperCase(curr));
                    
                     que.offer(currstr);
                  
                    // System.out.println(que);
                }
                sz--;
            }
            
        }
                               
        List<String> res = new ArrayList<String>();
                               
        while(!que.isEmpty())
         res.add(que.poll().toString());
                               
      return res;
        
        
    }
}