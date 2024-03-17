import java.util.*;
import java.io.*;

/**
 * MazeTester uses recursion to determine if a maze can be traversed.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class MazeTester
{

    /**
     * Creates a new maze, prints its original form, attempts to
     * solve it, and prints out its final form.
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the name of the file containing the maze: ");
        String filename = scan.nextLine();

        // String filename =  "resource/maze.txt";

        Maze labyrinth = new Maze(filename);

        //int r = 0; int c = 0;

        //int rows = labyrinth.getRowsStart();
        //int columns = labyrinth.getColStart();

        // file path: /Users/tishagaines/Desktop/Recursive_Maze/resource/maze.txt


        // Maze labyrinth = new Maze("resource/maze.txt");

        System.out.println(labyrinth);

        MazeSolver solver = new MazeSolver(labyrinth);

        if (solver.traverse(labyrinth.rowStart, labyrinth.colStart)) {
            System.out.println("Solution found!");
            System.out.println("solve_maze was called " + solver.getStepCount() + " times.");//stepcount
            System.out.println("There are " + labyrinth.getBreadCrumbs() + " breadcrumbs."); //labyrinth getBreadCrumbs

        }
        else
            System.out.println("There is no possible path.");

        System.out.println("Solution: ");
        System.out.println(labyrinth);

    }
}



// Change grid to 4/4 to 0 for no possible paths