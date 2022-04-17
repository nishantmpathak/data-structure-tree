package com.company;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class RightSideView {
    public static void rightSideView(Node root){
        if(root==null){
            return;
        }
        class QueueLevel{
            Node node;
            int level;
            QueueLevel(Node node, int level){
                this.node = node;
                this.level = level;
            }
        }

        Queue<QueueLevel> queue = new LinkedList<>();
        queue.add(new QueueLevel(root,0));
        Map<Integer, Node> rightView = new TreeMap<>();
        while(!queue.isEmpty()){
            var temp = queue.poll();
            if(!rightView.containsKey(temp.level)){
                rightView.put(temp.level, temp.node);
            }
            if(temp.node.right!=null){
                queue.add(new QueueLevel(temp.node.right, temp.level+1));
            }
            if(temp.node.left!=null){
                queue.add(new QueueLevel(temp.node.left, temp.level+1));
            }
        }
        for (Map.Entry<Integer, Node> temp:rightView.entrySet()) {
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
        root.right = new Node(3);
        root.right.right = new Node(10);
        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.right.right = new Node(6);
        root.left.right.right.right.right = new Node(7);
        System.out.println(
                "Following are nodes in left side view of Binary Tree");
        rightSideView(root);
    }
}
