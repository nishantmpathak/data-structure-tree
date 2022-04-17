package com.company;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class TreeBottomView {
    public static void bottomView(Node root){
        if(root==null){
            return;
        }
        class QueueHeight{
            Node node;
            int height;
            QueueHeight(Node node, int height){
                this.node = node;
                this.height = height;
            }
        }
        Queue<QueueHeight> q = new LinkedList<>();
        q.add(new QueueHeight(root,0));
        Map<Integer, Node> bottomView = new TreeMap<>();
        while(!q.isEmpty()){
            var temp = q.poll();
            bottomView.put(temp.height, temp.node);
            if(temp.node.left!=null){
                q.add(new QueueHeight(temp.node.left, temp.height-1));
            }
            if(temp.node.right!=null){
                q.add(new QueueHeight(temp.node.right, temp.height+1));
            }
        }
        for (Map.Entry<Integer, Node> temp:bottomView.entrySet()) {
            System.out.print(temp.getValue().data);
        }
    }

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
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(8);
        root.left.left.left = new Node(9);
        root.left.left.left.left = new Node(11);
        root.right = new Node(3);
        root.right.right = new Node(10);
        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.right.right = new Node(6);
        root.left.right.right.right.right = new Node(7);
        System.out.println(
                "Following are nodes in left side view of Binary Tree");
        bottomView(root);
    }
}
