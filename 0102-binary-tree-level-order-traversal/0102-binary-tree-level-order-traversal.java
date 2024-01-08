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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        //Base Case .
        if(root == null)return res;
        
        //creating a Queue.
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            //cal the level
            int levelSize = q.size();
            //Store currlevel in a arraylist.
            List<Integer> currLevel = new ArrayList<>();
            for(int i = 0;i<levelSize;i++){
                TreeNode curr = q.poll();
                currLevel.add(curr.val);
                
                if(curr.left!= null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }
            res.add(currLevel);
        }
        return res;
    }
}