package pij.day14.list;

public class Exercise1Runner {
    public static void main(String[] args) {
        Node<String> myNode = Node.createSelfLoop();
        int size = myNode.size();
        System.out.println(size);
    }
}
