class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        
        //int mod = (int)Math.pow(10, 9) +7;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int mxh = horizontalCuts[0];
        int mxv = verticalCuts[0];
        
        for(int i=1;i<horizontalCuts.length;i++){
            mxh = Math.max(horizontalCuts[i]-horizontalCuts[i-1], mxh);
        }
        //System.out.println(mxh+" "+mxv);
        mxh = Math.max(h-horizontalCuts[horizontalCuts.length-1], mxh);
        
        for(int i=1;i<verticalCuts.length;i++){
            mxv = Math.max(verticalCuts[i] - verticalCuts[i-1], mxv);
        }
        //System.out.println(mxh+" "+mxv);
        mxv = Math.max(w-verticalCuts[verticalCuts.length-1], mxv);
      //  System.out.println(mxh+" "+mxv);
         int mod = 1000000007;
        return (int)((long)(mxh % mod) * (long)(mxv % mod) % mod);
    }
    
}