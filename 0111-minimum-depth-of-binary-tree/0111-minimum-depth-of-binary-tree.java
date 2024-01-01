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
    public int minDepth(TreeNode root) {
        //base case..
        if(root == null){
            return 0;
        }
        int lh = minDepth(root.left)+1;
        int rh = minDepth(root.right)+1;
        if(root.left == null)return rh;
        if(root.right == null)return lh;
        return Math.min(lh, rh);
        
    }
}