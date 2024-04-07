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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer>ans = new ArrayList<>();
        
        if(root == null)return ans;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int levelSize = q.size();
            for(int i = 0;i<levelSize;i++){
                TreeNode currNode = q.poll();
                //the main logic is here.except that levelOder Copy Paste
                if( i == levelSize-1){
                    ans.add(currNode.val);
                }
                if(currNode.left!= null){
                    q.offer(currNode.left);
                }
                if(currNode.right!= null){
                    q.offer(currNode.right);
                }
            }
        }
        return ans;
    }
}