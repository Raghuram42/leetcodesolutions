class Solution {
    public String destCity(List<List<String>> paths) {
     HashMap<String, ArrayList<String>> hsm = new HashMap<String, ArrayList<String>>();
        
        for(List<String> str : paths){
            if(!hsm.containsKey(str.get(0)))
                hsm.put(str.get(0), new ArrayList<String>());
            
            hsm.get(str.get(0)).add(str.get(1));
        }
        String f = paths.get(0).get(0);
     while(hsm.containsKey(f)){
         f= hsm.get(f).get(0);
     }   
        return f;
        
    }
}