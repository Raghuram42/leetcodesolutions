class Solution {
    int[] fd;
    public List<Integer> countSmaller(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        int n = nums.length;
        Arrays.sort(copy);
        
        HashMap<Integer, Integer> mp = new HashMap<>();
        int rnk = 1;
        int i = 0;
        
        while(i<n){
            if(!mp.containsKey(copy[i])){
                mp.put(copy[i], rnk++);
            }
            i++;
        }
                fd = new int[mp.size()+1];
        i = n-1;
        List<Integer> res = new ArrayList<>();
        while(i>=0){
            
            int curr = mp.get(nums[i]);
            
            res.add(0, q(curr-1));
            u(curr);
            i--;
        }
        
        // System.out.println(mp+" "+Arrays.toString(fd));
        return res;
        
    }
    
    public void u(int pos){
        int n = fd.length;
        
        while(pos < n){
            fd[pos] += 1;
            pos += pos & -pos; 
        }
    }
    
    public int q(int d){
        int ans = 0;
        
        while(d>0){
            ans += fd[d];
            d -= d & -d; 
        }
        
        return ans;
    }
}