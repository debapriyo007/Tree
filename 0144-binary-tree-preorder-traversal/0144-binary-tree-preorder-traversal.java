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
    //Create an ArrayList.
    ArrayList<Integer> list = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        //base case
        if(root == null)return list;
        //PreOrder -> "Root" ->"Left" --> "Right"
        list.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return list;
    }
}