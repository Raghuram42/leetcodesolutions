// class NumArray {
//     int height;
//     int maxsize;
//     int[] segtree;
//     int arrlen;
//     public NumArray(int[] nums) {
//         height = (int)(Math.celi(Math.log(nums.length)/Math.log(2)));
//         maxsize = 2 * (int)Math.pow(2, height)-1;
//         segtree = new int[maxsize];
//         arrlen = nums.length-1;
//         buildTree(nums, 0, arrlen, 0);
//     }
    
//     public void update(int index, int val) {
//         int upddif = val - nums[index];
//         nums[index] = val;
        
//         updatenew(index, val, updiff, 0, );
//     }
    
//     public int sumRange(int left, int right) {
//         return sum(left, right, 0, arrlen, 0);
//     }
//     public int sum(int l, int r, int s,int e, int c){
//         if(s<=l && e >= r)
//             return segtree[c];
        
//         if(r<e || s>l)
//             return 0;
        
//         mid = (l+r)/2;
//         return sum(l, mid, s,e,(c*2)+1)+sum(mid+1, r, s,e,(c*2)+2);
        
//     }
//     public int buildTree(int[] nums, int startind, int endind, int curr){
//         if(startind == endind)
//             return segtree[curr] = nums[startind];
        
//         int mid = (startind+endind)/2;
        
//         return segtree[curr] = buildTree(nums, startind, mid, 2*curr+1)+buildTree(nums, mid+1, endind, 2*curr+2);
//     }
// }

// /**
//  * Your NumArray object will be instantiated and called as such:
//  * NumArray obj = new NumArray(nums);
//  * obj.update(index,val);
//  * int param_2 = obj.sumRange(left,right);
//  */
class NumArray {
    class TreeNode {
        int start, end;
        int sum;
        TreeNode left, right;
        public TreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.left = null;
            this.right = null;
            this.sum = 0;
        }
    }
    TreeNode root = null;
    public NumArray(int[] nums) {
        root = buildTree(nums, 0, nums.length - 1);
    }
    private TreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        } else {
            TreeNode node = new TreeNode(start, end);
            if (start == end) {
                node.sum = nums[start];
            } else {
                int mid = start + (end - start) / 2;
                node.left = buildTree(nums, start, mid);
                node.right = buildTree(nums, mid + 1, end);
                node.sum = node.left.sum + node.right.sum;
            }
            return node;
        }

    }

    public void update(int index, int val) {
        update(root, index, val);
    }

    private void update(TreeNode root, int index, int val) {
        if (root.start == root.end) {
            root.sum = val;
        } else {
            int mid = root.start + (root.end - root.start) / 2;
            if (index <= mid) {
                update(root.left, index, val);
            } else {
                update(root.right, index, val);
            }
            root.sum = root.left.sum + root.right.sum;
        }
    }


    public int sumRange(int left, int right) {
        return sumRange(root, left, right);
    }
    private int sumRange(TreeNode root, int start, int end) {
        if (root.start == start && root.end == end) {
            return root.sum;
        }
        int mid = root.start + (root.end - root.start) / 2;
        if (end <= mid) {
            return sumRange(root.left, start, end);
        } else if (start >= mid + 1) {
            return sumRange(root.right, start, end);
        } else {
            return sumRange(root.right, mid + 1, end) + sumRange(root.left, start, mid);
        }
    }
}