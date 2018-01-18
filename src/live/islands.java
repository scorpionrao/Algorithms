package live;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

/*
For example

1 1 1 0
0 1 0 0
0 0 0 0 = 3
1 0 1 0

0 1 1 0
0 1 0 0
0 0 0 0 = 2
1 1 1 0

*/
class islands {

    public static void calculateIslands(int[][] matrix) {
        int numOfIslands = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 1) {
                    // do DFS
                    DFS(matrix, i, j);
                    numOfIslands++;
                }
            }
        }
        System.out.println(numOfIslands);
    }

    private static void DFS(int[][] matrix, int i, int j) {
        // print(matrix);
        // boundaries
        if(i<0
                || j<0
                || i>=matrix.length
                || j>=matrix[0].length
                || matrix[i][j] != 1) {
            return;
        }

        // visited
        matrix[i][j] = 0;
        DFS(matrix, i+1, j);
        DFS(matrix, i-1, j);
        DFS(matrix, i, j+1);
        DFS(matrix, i, j+1);

        if(i == 0 || i == matrix.length - 1) {
            DFS(matrix, matrix.length - 1 - i, j);
        }

        if(j == 0 || j == matrix[i].length - 1) {
            DFS(matrix, i, matrix[i].length - 1 - j);
        }
    }

    private static void print(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
    /*
For example

0 1 1 0
0 1 0 0
0 0 0 0 = 1
1 0 1 1

0 1 1 0
0 1 0 0
0 0 0 0 = 2
1 1 1 0

*/

        int[][] matrix1 = {{0,1,1,0},{0,1,0,0},{0,0,0,0},{1,0,1,1}};
        calculateIslands(matrix1);

        int[][] matrix2 = {{0,1,1,0},{0,1,0,0},{0,0,0,0},{1,1,1,0}};
        calculateIslands(matrix2);


    }
}

