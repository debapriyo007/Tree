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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)return root;
        if(key>root.val){
            root.right = deleteNode(root.right, key); 
        }else if(key<root.val){
            root.left = deleteNode(root.left, key);
        }else{
            //case 1 .. jokhon particular node tar left ba right kono child thake be.
            if(root.left == null && root.right == null){
                return null;
            }
            //case 2 : Jodi left ba right child kono akata exist kore.
            if(root.right == null){
                return root.left;
            }else if(root.left == null){
                return root.right;
            }else{
                //Case 3: Jodi left ba right kono child e thak be na.
                //akhane amake In-OrderSuccessor findout korte hobe.
                TreeNode IS = findInOrderSuccsor(root.right);
                root.val = IS.val;
                root.right = deleteNode(root.right, IS.val);
            }
            
        }
        return root;
    }
    
    //In-OrderSuccssor Function.
    public static TreeNode findInOrderSuccsor(TreeNode root){
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }
}