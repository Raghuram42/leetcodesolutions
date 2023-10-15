class Solution {
    int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    HashSet<String> set;
     List<String> res;
    public List<String> findWords(char[][] board, String[] words) {
        res = new ArrayList<>();
        
        set = new HashSet<>();
        Arrays.sort(words, (a,b)->b.length()-a.length());
        
        Trie root = new Trie();
        
        for(String w: words)
            root.insert(w);
    
        int i = 0;
        int j = 0;
        int n = board.length;
        int m = board[0].length;
        int[] map = new int[26];
        for(String w: words){
           
            if(map[w.charAt(0)-'a'] == 1)
               continue;
            // System.out.println(w);
            for(i=0;i<n;i++){
                for(j=0;j<m;j++){
                    if(board[i][j] == w.charAt(0))
                        dfs(board, i, j, new boolean[n][m], root.root);    
                }
            }
            map[w.charAt(0)-'a'] = 1;
        }
        
        return new ArrayList<String>(set);
    }
    
    public boolean dfs(char[][] b, int i, int j, boolean[][] vis, Node root){
       
        if(i<0 || j<0 || i>=b.length || j >= b[0].length || vis[i][j])
            return false;
        
        int curr = b[i][j]-'a';
        if(root.children[curr] == null)
            return false;
        
        root = root.children[curr];
        if(root.isEnd)
            set.add(root.w);
        
        vis[i][j] = true;
        
        for(int k=0;k<4;k++){
                
            if(dfs(b, i+dir[k][0], j+dir[k][1], vis, root))
                return true;
        }
        
        vis[i][j] = false;

        return false;
    }
        class Node{
            Node[] children;
            String w;
            boolean isEnd;
            
            Node(){
                this.children = new Node[26];
                w = "";
            }
        }
    class Trie{
                Node root;
            Trie(){
                this.root = new Node();
            }
            public void insert(String w){
                int i = 0;
                int n = w.length();
                Node cur = root;
                
                while(i<n){
                    int cInd = w.charAt(i)-'a';
                    if(cur.children[cInd] == null)
                        cur.children[cInd] = new Node();
                    
                    cur = cur.children[cInd];
                    i++;
                }
                
                cur.isEnd = true;
                cur.w = w;
            }
            
            public boolean search(String w){
                 int i = 0;
                int n = w.length();
                Node cur = root;
                
                while(i<n){
                    int cInd = w.charAt(i)-'a';
                    if(cur.children[cInd] == null)
                        return false;
                    
                    cur = cur.children[cInd];
                    i++;
                }
                
                return cur != null && cur.isEnd;
            }
            
    }
}