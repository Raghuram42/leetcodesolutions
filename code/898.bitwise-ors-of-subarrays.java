class FreqStack {
    HashMap<Integer, Integer> hsm;
    int i;
    TreeMap<Integer, TreeSet<Integer>> tsm;
    HashMap<Integer, Integer> mapr;
    public FreqStack() {
        hsm = new HashMap<>();
        mapr = new HashMap<>();
        tsm = new TreeMap<>();
        
        i = 0;
        // maxfreq = 0;
    }
    
    public void push(int x) {
        mapr.put(i, x);
        if(!hsm.containsKey(x)){
        hsm.put(x , 0);
            if(!tsm.containsKey(1))
                tsm.put(1, new TreeSet<Integer>());
            tsm.get(1).add(i);
        }
        else{
            
            // System.out.println("bef" +" "+tsm);
            if(!tsm.containsKey(hsm.get(x)+1))
                tsm.put(hsm.get(x)+1, new TreeSet<Integer>());
            tsm.get(hsm.get(x)+1).add(i);
            
            // System.out.println(tsm);
        }
            
        
        hsm.put(x, hsm.get(x)+1);
    i++;
    }
    
    public int pop() {
        
        int maxkey = -1;
        int maxfreq = tsm.lastKey();
        int maxkeyind = tsm.get(maxfreq).last();
       
        tsm.get(maxfreq).remove(maxkeyind);
        if(tsm.get(maxfreq).size() == 0)
            tsm.remove(maxfreq);
        // System.out.println(mapr.get(maxkeyind) +" "+hsm+" "+tsm);
        if(hsm.get(mapr.get(maxkeyind)) == 1)
            hsm.remove(mapr.get(maxkeyind));
        else
            hsm.put(mapr.get(maxkeyind), hsm.get(mapr.get(maxkeyind))-1);
        return mapr.get(maxkeyind);
    }
}


/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */