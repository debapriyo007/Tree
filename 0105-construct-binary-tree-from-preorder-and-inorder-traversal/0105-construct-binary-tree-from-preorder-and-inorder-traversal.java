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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderIndexMapp = new HashMap<>();
        for(int i = 0 ;i<inorder.length;i++){
            inorderIndexMapp.put(inorder[i], i);
        }
        return helper(preorder,inorderIndexMapp,0, 0,inorder.length-1);
    }
    TreeNode helper(int[]preorder,Map<Integer, Integer>inorderIndexMapp,int rootIndex,int left, int right){
        TreeNode root = new TreeNode(preorder[rootIndex]);
        int mid = inorderIndexMapp.get(preorder[rootIndex]);
        
        if(mid>left){
            root.left = helper(preorder,inorderIndexMapp, rootIndex+1, left, mid-1);
        }
        if(mid<right){
            root.right = helper(preorder,inorderIndexMapp, rootIndex+mid-left+1, mid+1, right);
        }
        return root;
    }
}