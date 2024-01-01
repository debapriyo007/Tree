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
    //crete a class ..
    static class Info{
        int dia;
        int ht;

        //constructor..
        public Info(int dia , int ht){
            this.ht = ht;
            this.dia = dia;
        }
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        /*base case.
         if(root == null){
            return 0;
        }
        int leftDia = diameterOfBinaryTree(root.left);
        int leftHt = heightofNode(root.left);
        int rightDia = diameterOfBinaryTree(root.right);
        int rightHt = heightofNode(root.right);
        
        int selfDia = leftHt + rightHt;
        return Math.max(selfDia, Math.max(rightDia, leftDia));

    }

      // calculate the heigth of the tree..
       public static int heightofNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = heightofNode(root.left);
        int rh = heightofNode(root.right);
        return Math.max(lh, rh) + 1;*/
        
        
        return --diameter(root).dia;
    }
    
    //create a methord to claculate the diameter.
    public static Info diameter(TreeNode root){
        //base case..
        if(root == null){
            return new Info (0,0);
        }
        //calcuate left and rigth info.
        Info Leftinfo = diameter(root.left);
        Info Rightinfo = diameter(root.right);

        int dia = Math.max(Math.max(Leftinfo.dia ,Rightinfo.dia) ,Leftinfo.ht + Rightinfo.ht+1);
        int ht = Math.max(Leftinfo.ht,Rightinfo.ht)+1;
        return new Info(dia, ht);
    }
    
    
}