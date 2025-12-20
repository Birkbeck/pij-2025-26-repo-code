package pij.day10.pathFinder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Small example program to demonstrate how we can open a file using
 * a relative path, which will also work on someone else's computer.
 */
public class PathFinder2 {
    public static void main(String[] args) {

        // Our goal is to open the following file:
        // pij-2025-26-repo-code/src/Day10/pij/day10/temperatures/temperaturesOk1.csv

        // STEP 1:
        // Find out the absolute path of the current directory.
        // This is where a relative path would begin.
        //Path absoluteCurrentPath = Path.of("").toAbsolutePath();
        //System.out.println(absoluteCurrentPath);

        // STEP 2:

        // Imagine that the above two lines had the following output:
        // /Users/jdoe/IdeaProjects/pij-2025-26-repo-code

        // This tells us that when we write a relative path in our program and
        // run it with the current setup, the path will 'start' in the above
        // directory. We now know that we do not need to include
        // "pij-2025-26-repo-code" in the relative path to our file.
        // So to read all the lines in the file, we can write:

        Path p = Path.of("src", "Day10", "pij", "day10",
                "temperatures", "temperaturesOk1.csv");
        try {
            for (String line : Files.readAllLines(p)) {
                // do something with line here, e.g., print it on the screen
                System.out.println("SEEN LINE: " + line);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
