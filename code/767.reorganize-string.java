class Solution {
    public String reorganizeString(String S) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>(){
        @Override
        public int compare(int[] a, int[] b){
            return b[1]-a[1];
        }});
        
        
        int[] mapr = new int[26];
        
        for(int i=0;i<S.length();i++)
            mapr[S.charAt(i)-'a']++;
        
        for(int i=0;i<26;i++){
            if(mapr[i]*2 -1 > S.length())
                return "";
            else if(mapr[i] > 0)
                pq.offer(new int[]{i, mapr[i]});
        }
        
        
        StringBuilder res =new StringBuilder();
        
        int lastval = -1;
        while(!pq.isEmpty()){
            
            int[] a = pq.poll();
            if(a[0] != lastval){
                lastval = a[0];
                a[1]--;
                if(a[1] >0)
                    pq.offer(new int[]{a[0],a[1]});
            }
            else if(pq.isEmpty())
                return "";
            else{
                int[] b = pq.poll();
                lastval = b[0];
                b[1]--;
                if(b[1] > 0)
                    pq.offer(new int[]{b[0],b[1]});
                pq.offer(a);
            }
            
            res.append((char)(lastval+'a'));
            
        }
        
        return res.toString();
    }
}