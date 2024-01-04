//{ Driver Code Starts
// Initial Template for Java

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution g = new Solution();
            System.out.println(g.diameter(root));
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

/*class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}*/

class Solution {
    //create a class info which track the diameter as well as heigth.
    static class Info{
        int dia;
        int ht;
        //constr..
        Info(int dia, int ht){
            this.dia = dia;
            this.ht = ht;
        }
    }
    
    int diameter(Node root) {
        /*Time Complexity -- 0(n^2)
        if(root == null)return 0;
       int lh = heigth(root.left);
       int lefDia = diameter(root.left);
       int rh = heigth(root.right);
       int rightDia = diameter(root.right);
       
       int selfDia = lh+rh+1;
       return Math.max(Math.max(lefDia,rightDia ),selfDia);*/
       
       
       
       return DiameterCal(root).dia;
    }
    /*public static int heigth(Node root){
        if(root == null)return 0;
        int lh = heigth(root.left);
        int rh = heigth(root.right);
        return Math.max(lh, rh)+1;
    }*/

    //Methord to calculate the diameter.
    public static Info DiameterCal(Node root){
        //base case.
        if(root == null){
            return new Info(0, 0);
        }
        Info leftInfo = DiameterCal(root.left);
        Info rightInfo = DiameterCal(root.right);
        
        int selfDia = Math.max(Math.max(leftInfo.dia,rightInfo.dia), leftInfo.ht + rightInfo.ht+1);
        int ht = Math.max(leftInfo.ht,rightInfo.ht)+1;
        return new Info(selfDia,ht);
    }
    
}
