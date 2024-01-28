class Solution {
    class Point{
        int x;
        boolean start;
        int h;
        
        Point(int x, boolean start, int h){
            this.x = x;
            this.start = start;
            this.h = h;
        }
        
        @Override
        public String toString(){
            return this.x+" "+this.start+" "+this.h;
        }
        
    }
        
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<Point> points = new ArrayList<>();
        
        for(int[] b: buildings){
            points.add(new Point(b[0], true, b[2]));
            points.add(new Point(b[1], false, b[2]));
        }
        
 Collections.sort(points, new Comparator<Point>(){
            @Override 
            public int compare(Point p1, Point p2){
                if(p1.x == p2.x){
                    if(p1.start && p2.start)
                        return p2.h-p1.h;
                    else if(!p1.start && !p2.start)
                        return p1.h-p2.h;
                      return -1;
                }
                return p1.x-p2.x;
            }
        });                // System.out.println(points);

                // points.sort(Comparator.comparingInt((Point a) -> a.x).thenComparingInt(b -> b.start ? -b.h : b.h));

        // System.out.println(points);
        List<List<Integer>> res = new ArrayList<>();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int prev = 0;
                map.put(0, 1); // max = 0,freq =1

        for(int i=0;i<points.size();i++){
            Point curr = points.get(i);
            
            if(curr.start){
                map.put(curr.h, map.getOrDefault(curr.h, 0)+1);            
            }else{
             map.put(curr.h, map.getOrDefault(curr.h, 0)-1);
                if(map.get(curr.h) == 0)
                    map.remove(curr.h);
            }
            // System.out.println(map+" "+i+" "+curr+" "+res);
            Integer currM = map.lastKey();
            
            if(currM != prev){
                prev = currM;
                List<Integer> t = Arrays.asList(new Integer[]{curr.x, currM});
                res.add(t);
            }
        }
        
        return res;
    }
}