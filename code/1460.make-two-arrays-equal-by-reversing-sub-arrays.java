class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        if(target.length != arr.length || arr.length == 0 || target.length == 0)
            return false;
        Arrays.sort(arr);
        Arrays.sort(target);
        return Arrays.equals(target, arr);
    }
}