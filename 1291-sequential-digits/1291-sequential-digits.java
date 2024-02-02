class Solution {
    List<Integer> res;
    HashSet<Integer> set;
    public List<Integer> sequentialDigits(int low, int high) {
        res = new ArrayList<>();
        set = new HashSet<>();
        s(low, high, 0);
        Collections.sort(res);
        return res;
    }
    public void s(int low, int high, int num){
        if(num > high || set.contains(num))
            return;
        set.add(num);
        if(num >= low && num <= high)
            res.add(num);
        int v = (num+1)%10;
        // System.out.println(num+" "+v);
        if(num > 0 && v%10==0)
            return;
        s(low, high, num*10+v);
        
        s(low, high, v);
    }
}