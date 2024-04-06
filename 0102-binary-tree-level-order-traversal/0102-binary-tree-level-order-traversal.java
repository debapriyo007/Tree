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

//Here apply BFS algo.
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>res = new ArrayList<>();
        if(root== null)return res;
        
        //Step1 : Create Queue and add root on it.
        Queue<TreeNode>q = new LinkedList<>();
        q.offer(root);
        
        //Step2: While my queue is not empty. cal each level size.
        while(!q.isEmpty()){
            int levelSize = q.size();
            List<Integer>currLevelList = new ArrayList<>();
            
            // step 3:Itertate on that levelsize and take currnode and add that in my list
            for(int i = 0;i<levelSize;i++){
                TreeNode currNode = q.poll();
                currLevelList.add(currNode.val);
                
                //if currNode left ta jodi null na hoi ami abar queue the add korbo
                if(currNode.left!= null){
                    q.offer(currNode.left);
                }
                if(currNode.right!= null){
                    q.offer(currNode.right);
                }
            }
            
            res.add(currLevelList);
        }
        return res;
    }
}