class Solution {
    public int maximumPopulation(int[][] logs) {
        int resmax = 0;
        int year = 2050;
        for(int y=1950;y<=2050;y++){
            int ans = 0;
            for(int i=0;i<logs.length;i++){
                if(y >= logs[i][0] && y<= logs[i][1]-1)
                    ans++;
            }
            if(resmax < ans && ans != 0){
                resmax = ans;
                year = y;
                // System.out.println(y+" "+ans);
            }
        }
        
        return year;
    }
}