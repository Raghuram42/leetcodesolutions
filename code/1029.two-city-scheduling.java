class Solution {
    class Sortbyvalue implements Comparator<int[]> 
{ 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(int[] a, int[] b) 
    { 
        return a[0]-a[1] > b[0]-b[1] ? 1 : -1; 
    } 
} 
    public int twoCitySchedCost(int[][] costs) {
        Arrays.sort(costs, new Sortbyvalue());
        int res = 0;
        for(int i=0;i<costs.length;i++)
               res += (i < costs.length/2) ? costs[i][0] : costs[i][1];
        return res;
    }
}

