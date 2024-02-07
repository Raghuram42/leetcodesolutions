class Solution {
    public String frequencySort(String s) {
        int n = s.length();
        int[][] map = new int[256][2];
        
        for(int i=0;i<n;i++){
            map[s.charAt(i)][0]++;
            map[s.charAt(i)][1] = (int)(s.charAt(i));
        }
        
        Arrays.sort(map, (a, b)->b[0]-a[0]);
        StringBuilder res = new StringBuilder();
        
        for(int i=0;i<256;i++){
            if(map[i][0] == 0)
                break;
            
            while(map[i][0] > 0){
                map[i][0]--;
                res.append((char)(map[i][1]));
            }
                
        }
        
        return res.toString();
        
    }
}