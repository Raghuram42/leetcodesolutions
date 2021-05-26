class Solution {
    public int[] sortByBits(int[] arr) {
        
        Integer[] clone = new Integer[arr.length];
        
        for(int i=0;i<arr.length;i++)
            clone[i] = arr[i];
        Arrays.sort(clone, new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                if(Integer.bitCount(a) == Integer.bitCount(b))
                    return a-b;
                return Integer.bitCount(a)-Integer.bitCount(b);
            }
        });
        
        for(int i=0;i<arr.length;i++)
            arr[i] = clone[i];
        return arr;
    }
}