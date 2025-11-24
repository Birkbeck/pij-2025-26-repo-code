package pij.day15.graph;

import java.util.List;

/**
 * Driver class for Day 15, Exercise 6.
 */
public class GraphDriver {

    /** Constants for creating the example graph. */
    private static final int FIRST_VALUE = 20;
    private static final int NUMBER_OF_NODES = 5;

    /**
     * @return the example graph presented in the exercise
     */
    private static Graph<Integer> makeGraph() {
        Graph<Integer> g = new Graph<>();
        for (int i = FIRST_VALUE; i < FIRST_VALUE+NUMBER_OF_NODES; i++) {
            g.addNode(i); // node at index has data index+FIRST_VALUE
        }
        g.addEdge(0, 1);
        g.addEdge(1, 0);
        g.addEdge(4, 1);
        g.addEdge(1, 2);
        g.addEdge(2, 2);
        return g;
    }

    /**
     * Exercises method sizeFrom(int) on the first NUMBER_OF_NODES nodes of g.
     *
     * @param g the graph on which we want to exercise method sizeFrom(int)
     * @throws NullPointerException if g is null
     */
    private static void driveSize(Graph<Integer> g) {
        for (int i = 0; i < NUMBER_OF_NODES; i++) {
            int size = g.sizeFrom(i);
            System.out.println("Nodes reachable from node " + i + ": " + size);
        }
    }

    /**
     * Exercises method getDataFrom(int) on the first NUMBER_OF_NODES nodes of g.
     *
     * @param g the graph on which we want to exercise method getDataFrom(int)
     * @throws NullPointerException if g is null
     */
    private static void driveGetDataFrom(Graph<Integer> g) {
        for (int i = 0; i < NUMBER_OF_NODES; i++) {
            List<Integer> values = g.getDataFrom(i);
            System.out.println("Data reachable from node " + i + ": " + values);
        }
    }

    /**
     * Entry point for this driver class.
     *
     * @param args ignored.
     */
    public static void main(String[] args) {
        Graph<Integer> g = makeGraph();
        driveSize(g);
        driveGetDataFrom(g);
    }
}
