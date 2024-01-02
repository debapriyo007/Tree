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
        ArrayList<Integer> list = new ArrayList<>();
        rightView(root, list, 0);
        return list;

    }
    public static void rightView(TreeNode node, ArrayList<Integer> list, int currDepth){
        if(node == null){
            return;
        }
        if(currDepth == list.size()){
            list.add(node.val);
        }
        rightView(node.right, list,currDepth+1);
        rightView(node.left, list,currDepth+1);
    }
}