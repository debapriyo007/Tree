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
    public TreeNode invertTree(TreeNode root) {
        
        //Base case.
        if(root == null)return null;
        
        //ami left side er mirror ta ke ber korbo.
        TreeNode leftMirror = invertTree(root.left);
        TreeNode rightMirror = invertTree(root.right);
        
        //edge dutoke change kore dubo.
        root.left = rightMirror;
        root.right = leftMirror;
            
        return root;
    }
}