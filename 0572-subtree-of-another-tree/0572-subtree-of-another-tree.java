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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null){
            return false;
        }
       if(root.val == subRoot.val){ //jodi root r subroot value soman hoi 
           //check korbo Identical ki na?
           if(isIdentical(root, subRoot)){
               return true;
           }
       } 
        
        /*Left subTree te Kujbo j 
        boolean leftAns = isSubtree(root.left,subRoot); //if exist is left Subtree --> True
        boolean rightAns = isSubtree(root.right,subRoot);*/
        
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
        
    }
    
    
    
    
    //Check the Identical or not Methord.
    public static boolean isIdentical(TreeNode node , TreeNode subRoot){
        //write the non-identical logic
        if(node == null && subRoot == null){
            return true;
        }else if(node == null || subRoot == null || node.val!=subRoot.val){
            return false;
        }
        
        //check korbo j left sub tree vetor non-identical noy tho.
        if(!isIdentical(node.left, subRoot.left)){
            return false;
        }
         if(!isIdentical(node.right, subRoot.right)){
            return false;
        }
        
        //jodi uporeer akta condition o true na hoi tar name identical
        //so return korbo true.
        return true;
    }
}