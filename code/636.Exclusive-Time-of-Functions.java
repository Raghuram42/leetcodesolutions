class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<int[]> stk = new Stack<>();
        int[] map = new int[n];
        int i = 0;
        while(i<logs.size()){
            String[] logDetails = logs.get(i).split(":");
            int functionId = Integer.parseInt(logDetails[0]);
            String status = logDetails[1];
            int time = Integer.parseInt(logDetails[2]);
              // System.out.println(Arrays.toString(logDetails));
            if(stk.isEmpty()){
                stk.push(new int[]{functionId, time});
                // map[functionId] = time;
            }else if(status.equals("end")){
                // System.out.println(Arrays.toString(map)+" "+stk);
                map[stk.peek()[0]] += time-stk.peek()[1]+1;
                stk.pop();
                if(!stk.isEmpty())
                stk.peek()[1] = time+1;
            }else{
                map[stk.peek()[0]] += time-stk.peek()[1];
                stk.peek()[1] = time+1;
                stk.push(new int[]{functionId, time});
            }
            
            i++;
        }
        return map;
    }
}
