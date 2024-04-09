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
    int count = 0;
    public int kthSmallest(TreeNode root, int k) {
        return helper(root, k).val;
    }
    
    TreeNode helper(TreeNode root, int k){
        if(root == null)return null;
        
        TreeNode left = helper(root.left, k);
        if(left!= null){
            //meeans my ans is found.
            return left;
        }
        count++;
        if(count == k)return root;
        //otherwise my ans is on right side.
        return helper(root.right, k);
    }
}