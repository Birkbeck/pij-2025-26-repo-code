package pij.day14solutions.list;

public class Exercise1Runner {
    public static void main(String[] args) {
        Node<String> myNode = Node.createSelfLoop();

        // The call to myNode.size() does not terminate: the path from myNode
        // does not end (the path is infinite). Note that the loop-based
        // implementation of method size() uses constant memory on the call
        // stack and does _not_ throw a StackOverflowError! A recursive
        // implementation of method size() in Java would quickly run out of
        // stack memory.
        int size = myNode.size();
        System.out.println(size);
    }
}
