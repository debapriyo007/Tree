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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)return res;
        
        Deque<TreeNode>q = new LinkedList<>();
        q.offer(root);
        
        //take a flag to maintain normal and reverse
        boolean rev = false;
        while(!q.isEmpty()){
            int levelSize = q.size();
            List<Integer>list = new ArrayList<>();
            for(int i = 0;i<levelSize;i++){
            //there are two case "Normal Order" or "Reverse Order".
                if(!rev){
                    TreeNode currNode = q.pollFirst();
                    list.add(currNode.val);
                    if(currNode.left!= null){
                        q.addLast(currNode.left);
                    }
                    if(currNode.right!= null){
                        q.addLast(currNode.right);
                    } 
                }else{
                    TreeNode currNode = q.pollLast();
                    list.add(currNode.val);
                     if(currNode.right!= null){
                        q.addFirst(currNode.right);
                    }
                    if(currNode.left!= null){
                        q.addFirst(currNode.left);
                    }
                }
               
            }
            rev = !rev;
            res.add(list);
        }
        return res;
    }
}