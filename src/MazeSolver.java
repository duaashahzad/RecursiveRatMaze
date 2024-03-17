/**
 * MazeSolver attempts to recursively traverse a Maze. The goal is to get from the
 * given starting position to the bottom right, following a path of 1's. Arbitrary
 * constants are used to represent locations in the maze that have been TRIED
 * and that are part of the solution PATH.
 *
 * @author Java Foundations
 * @version 4.0
 */
public class MazeSolver
{
    private Maze maze;
    //private char breadcrumb = 'o';
     int stepCount = 0;

    /**
     * Constructor for the MazeSolver class.
     */
    public MazeSolver(Maze maze)
    {
        this.maze = maze;
    }
    /**
     * Attempts to recursively traverse the maze. Inserts special
     * characters indicating locations that have been TRIED and that
     * eventually become part of the solution PATH.
     *
     * @param row row index of current location
     * @param column column index of current location
     * @return true if the maze has been solved
     */
    public boolean traverse(int row, int column)
    {
        boolean done = false;
        //maze.rowStart = row;
        //maze.colStart = column;

        if (maze.validPosition(row, column))
        {
            System.out.println("The rat is at " + row + ", "  + column + "."); //include the current position
            stepCount++;

            maze.tryPosition(row, column);   // mark this cell as tried

            if (row == maze.rowEnd && column == maze.colEnd)
            {done = true; } // the maze is solved
            else
            {

               // maze.dropBreadCrumb(row, column);//drop a breadcrumb at current position
                done = traverse(row-1, column); //up
                if (!done)
                    done = traverse(row+1, column);      // down
                if (!done)
                    done = traverse(row, column+1);  // right
                if (!done)
                    done = traverse(row, column-1);  // left
            }

            if (done)  // this location is part of the final path
                maze.markPath(row, column);
            //stepCount++;
        }

        //stepCount++;
        //maze.removeBreadCrumb(row, column); //Pick up the breadcrumb from our current position because breadcrumbs only
        //mark the solution, and we didn't find one from here. - "o"
        return done;

    }

    public int getStepCount()
    {
        return stepCount;
    }
}
