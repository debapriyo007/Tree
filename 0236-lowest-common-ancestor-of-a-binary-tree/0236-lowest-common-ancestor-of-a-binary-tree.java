/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
      if(root == null || root == p || root == q)return root;
        TreeNode leftLca = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLca = lowestCommonAncestor(root.right, p, q);
        if(leftLca!= null && rightLca!= null)return root;// If both leftLca and rightLca are not null, it means p and q are found in different subtrees,
        // hence root is the lowest common ancestor
        return leftLca == null ? rightLca : leftLca;  
    }
}