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
        //base case.
        if(root == null || root.val == p.val || root.val == q.val){
            return root;
        }
        
        TreeNode left_LCA = lowestCommonAncestor(root.left, p, q);//ami recursively left subtree er LCA calculate korbo
        TreeNode right_LCA = lowestCommonAncestor(root.right, p, q);//ami recursively right subtree er LCA calculate korbo
        
        if(right_LCA == null){ //jodi rightLCA amr null hoi tarmane left side a commom ansistor ache..
            return left_LCA;
        }
        if( left_LCA == null){//jodi leftLCA amr null hoi tarmane right side a commom ansistor ache..
            return right_LCA;
        }
        
        return root; //jodi leftLCA r RightLCA konotai null na hoi thahole current node ta amr Common Ansistor.
    }
}