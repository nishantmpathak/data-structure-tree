package com.company;

import java.util.*;

public class LeftSideView {
    public static void leftSideView(Node root){
        if(root == null){
            return;
        }
        class LevelQueue{
            Node node;
            int level;
            LevelQueue(Node node, int level){
              this.node = node;
              this.level = level;
            }
        }

        Queue<LevelQueue> q = new LinkedList<>();
        q.add(new LevelQueue(root, 0));
        Map<Integer, Node> leftView = new TreeMap<>();
        while(!q.isEmpty()){
            var temp = q.poll();
            if(!leftView.containsKey(temp.level)){
                leftView.put(temp.level, temp.node);
            }
            if(temp.node.left!=null){
                q.add(new LevelQueue(temp.node.left, temp.level+1));
            }
            if(temp.node.right!=null){
                q.add(new LevelQueue(temp.node.right, temp.level+1));
            }
        }

        for (Map.Entry<Integer, Node> temp:leftView.entrySet()) {
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
        root.left.right = new Node(4);
        root.left.right.right = new Node(5);
        root.left.right.right.right = new Node(6);
        root.left.right.right.right.right = new Node(7);
        System.out.println(
                "Following are nodes in left side view of Binary Tree");
        leftSideView(root);
    }
}
