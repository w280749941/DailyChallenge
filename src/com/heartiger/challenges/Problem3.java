package com.heartiger.challenges;

import java.util.LinkedList;
import java.util.Queue;

/*
    This problem was asked by Google.

    Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.

    For example, given the following Node class

    class Node:
        def __init__(self, val, left=None, right=None):
            self.val = val
            self.left = left
            self.right = right
    The following test should pass:

    node = Node('root', Node('left', Node('left.left')), Node('right'))
    assert deserialize(serialize(node)).left.left.val == 'left.left'
 */
public class Problem3 {

    static class Node{
        String val;
        Node left;
        Node right;

        public Node(String val){
            this.val = val;
        }

        public Node(String val, Node left){
            this.val = val;
            this.left = left;
        }

        public Node(String val, Node left, Node right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static String serialize(Node node){
        if(node == null){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Queue<Node> qu = new LinkedList<>();
        qu.offer(node);
        sb.append(node.val).append("|");
        while(!qu.isEmpty()){
            Node curr = qu.poll();
            if(curr.left != null){
                qu.offer(curr.left);
                sb.append(curr.left.val).append("|");
            } else {
                sb.append("NULL|");
            }

            if(curr.right != null){
                qu.offer(curr.right);
                sb.append(curr.right.val).append("|");
            } else {
                sb.append("NULL|");
            }
        }

        return sb.toString();
    }

    private static Node deserialize(String serializedNode){
        String[] nodeVals = serializedNode.split("\\|");
        int i=0;
        Node node = getNode(nodeVals[i++]);
        Node head = node;
        Queue<Node> qu = new LinkedList<>();
        qu.offer(node);
        while(!qu.isEmpty()){
            node = qu.poll();
            node.left = getNode(nodeVals[i++]);
            node.right = getNode(nodeVals[i++]);
            if(node.left != null){
                qu.offer(node.left);
            }
            if(node.right != null){
                qu.offer(node.right);
            }
        }
        return head;
    }

    private static Node getNode(String val){
        return val.equals("NULL") ? null : new Node(val);
    }

    private static boolean binaryTreeEqual(Node node1, Node node2){
        if(node1 == null && node2 == null) {
            return true;
        }
        if(node1 == null || node2 == null) {
            return false;
        }

        return node1.val.equals(node2.val) && binaryTreeEqual(node1.left, node2.left) && binaryTreeEqual(node1.right, node2.right);
    }

    public static void main(String[] args) {

        Node node = new Node("root", new Node("left", new Node("left.left")), new Node("right"));
        Node serializeDeserializedNode = deserialize(serialize(node));
        assert binaryTreeEqual(node, serializeDeserializedNode): "Two nodes are not equal";
        System.out.println("PASSED");

    }
}
