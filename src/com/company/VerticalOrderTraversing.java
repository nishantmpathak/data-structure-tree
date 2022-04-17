package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VerticalOrderTraversing {

    public static void verticalTraversing(Node root, Map<Integer, ArrayList<Node>> map, int distance){
        if(root == null){
            return;
        }
        var list= map.get(distance);
        if(list == null){
            ArrayList<Node> newList = new ArrayList<>();
            newList.add(root);
            map.put(distance, newList);
        }
        else{
            list.add(root);
            map.put(distance, list);
        }
        verticalTraversing(root.left, map, distance-1);
        verticalTraversing(root.right, map, distance+1);

    }

    public static void main(String[] args) {
        Map<Integer, ArrayList<Node>> map = new HashMap<>();
        Node node = new Node(0);
        node.left = new Node(-1);
        node.right = new Node(1);
        node.left.left = new Node(-2);
        node.left.right = new Node(-3);
        node.right.left = new Node(3);
        node.right.left.right = new Node(4);
        verticalTraversing(node, map, 0);


        for (Map.Entry<Integer, ArrayList<Node>> val: map.entrySet()) {
            System.out.print("key is "+val.getKey()+" value are ");
            val.getValue().stream().forEach(n-> System.out.print(" "+n.data+" "));
            System.out.println();
        }
    }
}
