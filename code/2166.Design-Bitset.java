class Bitset {
    int[] map;
    int ones;
    int size;
    int mod;
    public Bitset(int size) {
        map = new int[size];
        mod = 0;
        this.size = size;
    }
    
    public void fix(int idx) {
        if(map[idx] == mod)
        {
            map[idx] = mod == 0 ? 1: 0;
            ones++;
        }
    }
    
    public void unfix(int idx) {
        if(map[idx] != mod)
        {
            map[idx] = mod;
            ones--;
        }
    }
    
    public void flip() {
        if(mod == 1)
            mod = 0;
        else
            mod = 1;
        
        ones = size-ones;
    }
    
    public boolean all() {
        return size == ones;
    }
    
    public boolean one() {
        return ones>0;
    }
    
    public int count() {
        return ones;
    }
    
    public String toString() {
        StringBuilder res = new StringBuilder();
        for(int i=0;i<size;i++)
            res.append(map[i]==mod ? 0 : 1);
        
        return res.toString();
    }
}

/**
 * Your Bitset object will be instantiated and called as such:
 * Bitset obj = new Bitset(size);
 * obj.fix(idx);
 * obj.unfix(idx);
 * obj.flip();
 * boolean param_4 = obj.all();
 * boolean param_5 = obj.one();
 * int param_6 = obj.count();
 * String param_7 = obj.toString();
 */
