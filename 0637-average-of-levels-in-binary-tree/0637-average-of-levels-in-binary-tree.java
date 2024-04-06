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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double>ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int levelSize = q.size();
            double avrageLevel = 0;
            for(int i = 0;i<levelSize;i++){
                TreeNode currNode = q.poll();
                avrageLevel+= currNode.val;
                
                if(currNode.left!= null){
                    q.offer(currNode.left);
                }
                if(currNode.right!= null){
                    q.offer(currNode.right);
                }
            }
            avrageLevel = avrageLevel/levelSize;
            ans.add(avrageLevel);
        }
        return ans;
    }
}