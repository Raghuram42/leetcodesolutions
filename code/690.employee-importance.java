
class Solution {
    HashMap<Integer, Employee> gf;
    public int getImportance(List<Employee> employees, int id) {
        if(employees.size() == 0)
            return 0;
        
        gf = new  HashMap<Integer, Employee>();
        
        for(Employee e: employees){
            // if(!gf.containsKey(e.id))
            // System.out.println(e);
            // if(e != null)
                gf.put(e.id, e);
            // gf.get(e.id).add(e);
        }
        if(!gf.containsKey(id))
            return 0;
        
     Queue<Integer> q = new LinkedList<Integer>();
        
        q.offer(id);
        int res = gf.get(id).importance;
        while(!q.isEmpty()){
            int sz = q.size();
           
            while(sz>0){
                int empid = q.poll();
            List<Integer> sub = gf.get(empid).subordinates;
                if(sub == null){
                    sz--;
                    continue;
                }
                for(int emp: sub){
                    if(gf.containsKey(emp)){
                    res += gf.get(emp).importance;
                        q.offer(emp);
                    }
                }
                
                sz--;
            }
            
        }
        return res;
        
    }
}