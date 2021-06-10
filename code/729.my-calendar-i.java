class MyCalendar {
List<int[]> map;
    public MyCalendar() {
        map = new ArrayList<int[]>();
    }
    
    public boolean book(int start, int end) {
    
        for(int i=0;i<map.size();i++){
            // System.out.println(start+" "+ end+" "+ map.get(i)[0]+" "+ map.get(i)[1]+" "+lies(start, end, map.get(i)[0], map.get(i)[1]) +" - "+ lies( map.get(i)[0], map.get(i)[1],start, end));
            if(lies(start, end, map.get(i)[0], map.get(i)[1]) || lies( map.get(i)[0], map.get(i)[1],start, end))
                return false;
        }
            map.add(new int[]{start, end});
         
        return true;
    }
    
    public boolean lies(int a, int b, int c, int d){
               // System.out.println(start+" "+ end+" "+ map.get(i)[0]+" "+ map.get(i)[1]);
        if((a >= c && a < d) || (b > c && b < d))
            return true;
        
        return false;
    }
    
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */