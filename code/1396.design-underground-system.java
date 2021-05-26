class UndergroundSystem {
    class Pair{
        int a; 
        String place;
        Double c;
        int b;
        Pair(int a, String place){
            this.a = a;
            this.place = place;
        }
        Pair(Double c, int b){
            this.c =c;
            this.b = b;
        }
        
        @Override
        public String toString(){
            return this.a+" b "+this.b+" c "+this.c+" place "+this.place;
        }
    }
    
    HashMap<Integer, Pair> in;
    // HashMap<Integer, Pair> out;
    HashMap<String , Pair> avgRes;
    public UndergroundSystem() {
        in = new HashMap<>();
        // out = new HashMap<>();
        avgRes = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        in.put(id, new Pair(t, stationName));
    }
    
    public void checkOut(int id, String stationName, int t) {
        String key = in.get(id).place+"$"+stationName;
        
        // System.out.println(key+" bef "+avgRes.get(key)+" "+(t-in.get(id).a));
        if(!avgRes.containsKey(key))
            avgRes.put(key, new Pair((double)(t- in.get(id).a), 1));
        else{
        Double val =(double)((avgRes.get(key).c*(avgRes.get(key).b))+(t-in.get(id).a))/(avgRes.get(key).b+1);
        avgRes.put(key, new Pair(val, avgRes.get(key).b+1));
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        return avgRes.get(startStation+"$"+endStation).c;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */