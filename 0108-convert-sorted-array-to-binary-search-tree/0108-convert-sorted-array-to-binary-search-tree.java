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
    public TreeNode sortedArrayToBST(int[] nums) {
        return blanceTree(nums, 0, nums.length-1);
    }
    //create a METHORD.
    public static TreeNode blanceTree(int[] nums, int si, int ei){
        //base case.
        if(si>ei)return null;
        int mid = (si+ei)/2;
        //Create a new node.
        TreeNode root = new TreeNode(nums[mid]);
        root.left = blanceTree(nums, si, mid-1);
        root.right = blanceTree(nums, mid+1, ei);
        return root;
    }
}