class Solution {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int m = arr[(n - 1) / 2];

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Math.abs(a - m) == Math.abs(b - m) ? b - a : Math.abs(b - m) - Math.abs(a - m));
        for (int a : arr) pq.add(a);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) res[i] = pq.poll();

        return res;
    }
}