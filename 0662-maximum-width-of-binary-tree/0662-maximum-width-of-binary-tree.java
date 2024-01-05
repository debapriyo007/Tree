/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        /*base case 
        if(root == null)return 0;
        
        //akata dequeue nubo keno? --> amar j approach ta te korbo seta te 
        // front and rear dudik theke element k remove koerte hobe.
        Deque<TreeNode> dq = new LinkedList<>();
        //prothome amara root k push korbo queue te.
        dq.add(root);
        
        //max var declear korbo.
        int maxWidth = 1;
        while(!dq.isEmpty()){
        //amara check korbo j amader dq te samne ba pichone koro "null" value ache kina 
        //jodi thake remove korbo.
            while(!dq.isEmpty() && dq.getFirst() == null) {
                dq.removeFirst();
            } 
            while(!dq.isEmpty() && dq.getLast() == null){
              dq.removeLast();  
            } 
            
            int size = dq.size();
            //tulona korbo amar curr dq er size er sather max er value.
            maxWidth = Math.max(maxWidth,size);
            for(int i = 0 ;i<size;i++){
                //er por ami current node ta ke pick korbo.
                TreeNode currNode = dq.poll();
                if(currNode == null){
                    dq.add(null);
                    dq.add(null);
                }else{
                    dq.add(currNode.left);
                    dq.add(currNode.right);
                }
            }
 
        }
        return maxWidth;*/
        
        if (root == null) {
        return 0;
        }
        int maxWidth = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> posQueue = new LinkedList<>();
        nodeQueue.add(root);
        posQueue.add(1);
    while (!nodeQueue.isEmpty()) {
        int size = nodeQueue.size();
        int left = 0, right = 0;
        for (int i = 0; i < size; i++) {
            TreeNode node = nodeQueue.poll();
            int pos = posQueue.poll();
            if (i == 0) {
                left = pos;
            }
            if (i == size - 1) {
                right = pos;
            }
            if (node.left != null) {
                nodeQueue.add(node.left);
                posQueue.add(pos * 2);
            }
            if (node.right != null) {
                nodeQueue.add(node.right);
                posQueue.add(pos * 2 + 1);
            }
        }
            maxWidth = Math.max(maxWidth, right - left + 1);
    }
        return maxWidth;
        
        
    }
}
