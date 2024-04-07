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
    public boolean isCousins(TreeNode root, int x, int y) {
        
        //Cousins menas -> Both are in same level but not Sibling.
        
        TreeNode xx = findNode(root, x);
        TreeNode yy = findNode(root, y);
        
        return (
        
            (level(root, xx, 0) == level(root, yy, 0)) && (!isSibling(root, xx, yy))
        );
        
    }
    
     //Find Methord.
    TreeNode findNode(TreeNode node, int x){
        if(node == null)return null;
        if(node.val == x)return node;
        TreeNode left = findNode(node.left, x);
        if(left!= null){
            return left;
        }
        return findNode(node.right, x);
    }
    
    //Sibling Methord.
    boolean isSibling(TreeNode node, TreeNode x, TreeNode y){
        if(node == null)return false;
        
        //how say these node are sibling.
        return (
            (node.left == x && node.right == y) || (node.left == y && node.right == x)
            || isSibling(node.left, x, y) || isSibling(node.right, x, y)
        );
    }
    
     //Level Methord.
    int level(TreeNode node, TreeNode x, int lev){
        if(node == null)return 0;
        if(node == x)return lev;
        int l = level(node.left, x, lev+1);
        if(l!= 0){
            return l;
        }
        return level(node.right, x, lev+1);
    }
}