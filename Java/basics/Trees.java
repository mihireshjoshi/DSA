package Java.basics;

import java.util.Stack;

class Node{
    int data;
    Node left, right;

    public Node(int item){
        data = item;
        left = right = null;
    }
}

public class Trees {
    static Node root;

    static void inorder(Node node){
        if(node==null){
            return;
        }
        inorder(node.left);
        System.out.println(node.data);
        inorder(node.right);
    }

    static void preorder(Node node){
        if(node==null){
            return;
        }
        System.out.println(node.data);
        preorder(node.left);
        preorder(node.right);
    }

    static void postorder(Node node){
        if(node==null){
            return;
        }
        postorder(node.left);
        postorder(node.right);
        System.out.println(node.data);
    }

    static void zigzagTraversal(){
        if(root==null){
            return;
        }

        Stack<Node> cl = new Stack<>();
        Stack<Node> nl = new Stack<>();

        cl.push(root);

        boolean leftRight = true;

        while(!cl.isEmpty()){
            Node node = cl.pop();
            System.out.println(node.data + " ");

            if(leftRight) {
                if(node.left != null){
                    nl.push(node.left);
                }
                if(node.right != null){
                    nl.push(node.right);
                }
            } else {
                if(node.right != null){
                    nl.push(node.right);
                }
                if(node.left != null){
                    nl.push(node.left);
                }
            }

            if(cl.isEmpty()){
                Stack<Node> temp = cl;
                cl = nl;
                nl = temp;
                leftRight = !leftRight;
            }
        }

    }

    public static void main(String[] args) {
        Trees tree = new Trees();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Inorder Traversal");
        tree.inorder(root);

        System.out.println("Preorder Traversal");
        tree.preorder(root);

        System.out.println("Postorder Traversal");
        tree.postorder(root);

        System.out.println("ZigZag Traversal");
        tree.zigzagTraversal();
    }
}
