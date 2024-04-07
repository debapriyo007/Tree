/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        //edge case.
        if(root == null)return null;
        
        //take a pointer on leftmost node of the tree.
        Node leftMost  = root;
        
        while(leftMost.left!= null){
            //take curr pointer for linking
            Node currNode = leftMost;
            while(currNode!=null){
                //when i'm particular node and that node is not null 
                //connect his childeren together.
                 currNode.left.next = currNode.right;
                
                //this is for connect the bridge between left most child and right most                 child. 
                if(currNode.next!=null){
                    currNode.right.next = currNode.next.left;
                }
                currNode = currNode.next; //update the currPointer.
            }
            //update my left most.
            leftMost = leftMost.left;
        }
      return root;
    }
}