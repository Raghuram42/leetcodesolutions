class Solution {
public:
    Node* connect(Node* root) {
        if(root==nullptr){
            return nullptr;
        }
        queue<Node*> q;
        q.push(root);
        
        while(!q.empty()){
            int size = q.size();
            Node *prev = nullptr;
            for(int i=0;i<size;i++){
                
                Node *first = q.front();
                q.pop();
                
                if(prev!=nullptr){
                    prev->next = first;
                }
                if(first->left) q.push(first->left);
                if(first->right) q.push(first->right);
                prev = first;
            }           
            
        }
        return root;
    }
};