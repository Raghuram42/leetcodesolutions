class Solution {
    public int[][] reconstructQueue(int[][] people) {
     
        Arrays.sort(people, new Comparator<int[]>(){
           @Override
            public int compare(int[] a, int[] b){
                if(a[0] == b[0])
                {
                    return a[1]-b[1];
                }
                return b[0] - a[0];
            }    
        });
        //return people;
        ArrayList<int[]> res = new ArrayList<>();
            
            for(int[] p : people)
                res.add(p[1], p);
            
        return res.toArray(new int[people.length][2]);
    }
}