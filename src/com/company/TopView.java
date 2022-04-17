package com.company;

import java.util.*;

public class TopView {

    Node root;

    public TopView() { root = null; }

    // function should print the topView of
    // the binary tree
    private void TopView(Node root)
    {

        class NodeWeight{
            int height;
            Node node;
            NodeWeight(Node node, int height){
                this.node = node;
                this.height = height;
            }
        }

        if(root == null){
            return;
        }
        Map<Integer, Node> topView = new TreeMap<>();
        Queue<NodeWeight> q = new LinkedList<>();
        q.add(new NodeWeight(root,0));
        topView.put(0, root);
        while(!q.isEmpty()){
            var temp = q.poll();
            if(!topView.containsKey(temp.height)){
                topView.put(temp.height, temp.node);
            }
            if(temp.node.left!=null){
                q.add(new NodeWeight(temp.node.left, temp.height-1));
            }
            if(temp.node.right!=null){
                q.add(new NodeWeight(temp.node.right, temp.height+1));
            }
        }

        for (Map.Entry<Integer, Node> temp:topView.entrySet()) {
            System.out.print(temp.getValue().data);
        }

    }

    // Driver Program to test above functions
    public static void main(String[] args)
    {
        /* Create following Binary Tree
            1
        / \
        2 3
        \
            4
            \
            5
            \
                6*/
        TopView tree = new TopView();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.left.left = new Node(8);
        tree.root.right = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.left.right.right = new Node(5);
        tree.root.left.right.right.right = new Node(6);
        tree.root.left.right.right.right.right = new Node(7);
        System.out.println(
                "Following are nodes in top view of Binary Tree");
        tree.TopView(tree.root);
    }
}
