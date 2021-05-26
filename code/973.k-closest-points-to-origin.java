class Solution {
    class Pair implements Comparable<Pair>{
        long dis;
        int[] point;
        
        Pair(int[] po){
            dis = (po[0] * po[0] * 1L) + (po[1] * po[1]* 1L);
            point = po;
        }
        
        @Override
        public int compareTo(Pair p){
            return (int)(this.dis - p.dis);
        }
    }
    
    
    public int[][] kClosest(int[][] points, int K) {
        
        if(K == points.length)
            return points;
        ArrayList<Pair> hsm = new ArrayList<Pair>();
        
        
        for(int i=0;i<points.length;i++)
            hsm.add(new Pair(points[i]));
        
        Collections.sort(hsm);
      //  System.out.println(hsm.get(8*1L)[0]);
        int[][] res = new int[K][2];
        int p = 0;
        for(int i=0;i<K;i++)
            res[i] =hsm.get(i).point;
        
// for(Map.Entry<Long,int[]> entry : hsm.entrySet()) {
//   if(K > 0){
//       res[p] = entry.getValue();
//           p++;
//       K--;
//   }
//     else
//         break;
// }
        
        return res;
    }
}