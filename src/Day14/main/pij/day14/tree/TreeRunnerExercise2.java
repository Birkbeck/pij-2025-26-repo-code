package pij.day14.tree;

/**
 * Driver class for Exercise 2.
 */
public class TreeRunnerExercise2 {
    public static void main(String[] args) {
        TreeNode<Integer> leaf = new TreeNode<>(3);
        TreeNode<Integer> middle = new TreeNode<>(2, leaf);
        TreeNode<Integer> root = new TreeNode<>(1, middle);
        root.printTreePreOrder();
    }
}
