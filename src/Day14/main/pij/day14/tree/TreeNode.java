package pij.day14.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * A node for a generic binary tree with a data element and
 * two pointers to the left and right child node. Class has
 * public visibility as it is exposed by a public constructor
 * of class Tree.
 *
 * @param <E> the type of elements in the node
 */
public class TreeNode<E> {
    /** The data object stored in this TreeNode<E>. May be null. */
    private E data;

    /** Reference to the left subtree. May be null. */
    private TreeNode<E> left;

    /** Reference to the right subtree. May be null. */
    private TreeNode<E> right;

    /**
     * Initialises a new TreeNode<E> using the parameter values.
     *
     * @param data reference to the data object to store in this TreeNode<E>
     * @param left reference to the left subtree
     * @param right reference to the right subtree
     */
    public TreeNode(E data, TreeNode<E> left, TreeNode<E> right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    /**
     * Initialises a new TreeNode<E> that has no left subtree and no right
     * subtree (a "leaf node").
     *
     * @param data reference to the data object to store in this TreeNode<E>
     */
    public TreeNode(E data) {
        this(data, null, null);
    }

    /**
     * Initialises a new TreeNode<E> with given data and a single reference
     * that will be used both for the left subtree and for the right subtree.
     * (Constructor added for Exercise 2.)
     *
     * @param data reference to the data object to store in this TreeNode<E>
     * @param leftAndRightChild reference to the left *and* the right subtree
     */
    public TreeNode(E data, TreeNode<E> leftAndRightChild) {
        this(data, leftAndRightChild, leftAndRightChild);
    }

    /**
     * Prints this TreeNode<E> and its subtrees on the screen using
     * recursive pre-order traversal.
     */
    public void printTreePreOrder() {
        System.out.println(this.data);
        if (this.left != null) {
            this.left.printTreePreOrder();
        }
        if (this.right != null) {
            this.right.printTreePreOrder();
        }
    }

    /**
     * Prints this TreeNode<E> and its subtrees on the screen using
     * recursive in-order traversal.
     */
    public void printTreeInOrder() {
        if (this.left != null) {
            this.left.printTreeInOrder();
        }
        System.out.println(this.data);
        if (this.right != null) {
            this.right.printTreeInOrder();
        }
    }

    /**
     * Prints this TreeNode<E> and its subtrees on the screen using
     * recursive post-order traversal.
     */
    public void printTreePostOrder() {
        if (this.left != null) {
            this.left.printTreePostOrder();
        }
        if (this.right != null) {
            this.right.printTreePostOrder();
        }
        System.out.println(this.data);
    }

    /**
     * Prints this TreeNode<E> and its subtrees on the screen using
     * iterative pre-order traversal with an explicit stack.
     */
    public void printTreePreOrderLoop() {
        Deque<TreeNode<E>> stack = new LinkedList<>();
        stack.push(this); // initiate the process: push this node on the stack
        while (!stack.isEmpty()) { // as long as nodes are left to visit...
            TreeNode<E> node = stack.pop(); // pop the next node for processing
            System.out.println(node.data); // do the task for the popped node
            // first push the child node on the stack that is to be visited /later/
            if (node.right != null) {
                stack.push(node.right);
            }
            // then push the child node on the stack that is to be visited /earlier/
            // (top-of-stack is popped next)
            if (node.left != null) {
                stack.push(node.left);
            }
        }
    }
}
