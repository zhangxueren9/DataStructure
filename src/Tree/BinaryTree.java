package Tree;

import node.Node;

import java.util.LinkedList;
import java.util.Queue;


public class BinaryTree {
    BinaryNode root = null;
    BinaryNode lchild = null;
    BinaryNode rchild = null;

    public BinaryTree() {
        super();
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        for (int i = 0; i < 10; i++) {
            tree.add(new BinaryNode(i));
        }

        tree.beadthTravel();
        System.out.println();
        tree.preOrderTravel(tree.root);
        System.out.println();
        tree.inOrderTravel(tree.root);
        System.out.println();
        tree.postOrderTravel(tree.root);

    }

    public boolean add(BinaryNode node) {
        if (node == null)
            return false;
        if (root == null) {
            root = node;
            return true;
        }
        Queue<BinaryNode> queue = new LinkedList<>();
        ((LinkedList<BinaryNode>) queue).addLast(root);
        while (!queue.isEmpty()) {
            BinaryNode curNode = ((LinkedList<BinaryNode>) queue).pop();
            if (curNode.lchild == null) {
                curNode.lchild = node;
                return true;
            } else {
                ((LinkedList<BinaryNode>) queue).addLast(curNode.lchild);
            }

            if (curNode.rchild == null) {
                curNode.rchild = node;
                return true;
            } else {
                ((LinkedList<BinaryNode>) queue).addLast(curNode.rchild);
            }
        }
        return true;
    }

    public void beadthTravel() {
        if (root == null)
            return;
        Queue<BinaryNode> queue = new LinkedList<>();
        ((LinkedList<BinaryNode>) queue).addLast(root);
        while (!queue.isEmpty()) {
            BinaryNode curNode = ((LinkedList<BinaryNode>) queue).pop();
            System.out.print(curNode.elem + ",");
            if (curNode.lchild != null) {
                ((LinkedList<BinaryNode>) queue).addLast(curNode.lchild);
            }
            if (curNode.rchild != null) {
                ((LinkedList<BinaryNode>) queue).addLast(curNode.rchild);
            }
        }
    }

    public void preOrderTravel(BinaryNode curNode) {
        if (curNode == null)
            return;
        System.out.print(curNode.elem + ",");
        preOrderTravel(curNode.lchild);
        preOrderTravel(curNode.rchild);
    }

    public void inOrderTravel(BinaryNode curNode) {
        if (curNode == null)
            return;
        inOrderTravel(curNode.lchild);
        System.out.print(curNode.elem + ",");
        inOrderTravel(curNode.rchild);
    }

    public void postOrderTravel(BinaryNode curNode) {
        if (curNode == null)
            return;
        System.out.print(curNode.elem + ",");
        postOrderTravel(curNode.lchild);
        postOrderTravel(curNode.rchild);
    }
}


class BinaryNode extends Node {
    BinaryNode lchild = null;
    BinaryNode rchild = null;

    public BinaryNode(Object elem) {
        super(elem);
    }
}
