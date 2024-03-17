import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Maze {

    //r bb c - maze.txt change - r's change, c's dont

    private static char TRIED = 'o';
    private static final char PATH = 'C';
    private int numberRows, numberColumns;
    private char[][] grid;
     int breadCrumbsCounter = 0;
    int rowStart;
    int rowEnd;
    int colStart;
    int colEnd;



    public Maze(String filename) throws FileNotFoundException {
        Scanner scan = new Scanner(new File(filename));
        numberRows = scan.nextInt();
        numberColumns = scan.nextInt();

        grid = new char[numberRows][numberColumns];
        for (int i = 0; i < numberRows; i++) {
            for (int j = 0; j < numberColumns; j++) {

                grid[i][j] = scan.next().charAt(0);

                if (grid[i][j] == 'R') {

                   // i = rowStart;
                   // j = colStart;
                    rowStart = getRowsStart(i,j);
                    colStart = getColStart(i,j);
                    System.out.println("Row: " + i + " Column: " + j);

                    // System.out.println(getRowsStart(i,j));
                    //System.out.println(getColStart(i,j));

                }

                if (grid[i][j] == 'C') {

                    rowEnd = getRowEnd(i,j);
                    colEnd = getColEnd(i,j);
                    System.out.println("Row:-- " + i + " Column:--- " + j);


                    //System.out.println(getRowEnd());
                    //System.out.println(getColEnd());

                }


            }
        }
    }

        public int getRowsStart(int rows, int column)
        {
            if(grid[rows][column] == 'R')
            {

            }
            return rows;
        }

        public int getColStart(int rows, int column) {
            if (grid[rows][column] == 'R') {

            }
            return column;
        }

        public int getRowEnd(int rows, int column)
        {
            if (grid[rows][column] == 'C') {

            }
            return rows;

        }

        public int getColEnd(int rows, int column)
        {
            if (grid[rows][column] == 'C') {

            }
            return column;
        }

        /**
         * Marks the specified position in the maze as TRIED
         *
         * @param row the index of the row to try
         * @param col the index of the column to try
         */
        public void tryPosition(int row, int col)
        {
            if(grid[row][col] != 'C') {
                grid[row][col] = TRIED;
            }
        }

        /**
         * Return the number of rows in this maze
         *
         * @return the number of rows in this maze
         */
        public int getRows()
        {
            return grid.length;
        }

        /**
         * Return the number of columns in this maze
         *
         * @return the number of columns in this maze
         */
        public int getColumns()
        {
            return grid[0].length;
        }

        /**
         * Marks a given position in the maze as part of the PATH
         *
         * @param row the index of the row to mark as part of the PATH
         * @param col the index of the column to mark as part of the PATH
         */
        public void markPath(int row, int col)
        {
            //grid[row][col] = PATH;

            if(grid[row][col] == 'C')
            {
                grid[row][col] = PATH;
               // breadCrumbsCounter++;
            }
            else
            {
                //grid[row][col] = TRIED;
                 breadCrumbsCounter++;
            }

        }
        /**
         * Determines if a specific location is valid. A valid location
         * is one that is on the grid, is not blocked, and has not been TRIED.
         *
         * @param row the row to be checked
         * @param column the column to be checked
         * @return true if the location is valid
         */
        public boolean validPosition(int row, int column)
        {
            boolean result = false;

            // check if cell is in the bounds of the matrix
            if (row >= 0 && row < grid.length &&
                    column >= 0 && column < grid[row].length)

                //  check if cell is not blocked and not previously tried
                if (grid[row][column] == '.' || grid[row][column] == 'R' || grid[row][column] == 'C' )
                    result = true;

            return result;
        }
        /**
         * Returns the maze as a string.
         *
         * @return a string representation of the maze
         */
        public String toString()
        {
            String result = "\n";

            for (int row=0; row < grid.length; row++)
            {
                for (int column=0; column < grid[row].length; column++)
                    result += grid[row][column] + "";
                result += "\n";
            }


            return result;
        }

        public int getBreadCrumbs()
        {
            return breadCrumbsCounter;
        }



}
