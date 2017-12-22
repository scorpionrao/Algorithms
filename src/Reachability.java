import java.util.ArrayList;
import java.util.Scanner;

public class Reachability {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<Integer>[] adjacentList = (ArrayList<Integer>[]) new ArrayList[n];
        for(int i = 0; i < n; i++) {
            adjacentList[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            adjacentList[x - 1].add(y - 1);
            adjacentList[y - 1].add(x - 1);
        }
        int x = scanner.nextInt() - 1;
        int y = scanner.nextInt() - 1;
        System.out.println(reach(adjacentList, x, y));
        scanner.close();
    }

    private static int reach(ArrayList<Integer>[] adjacentList, int x, int y) {
        // DFS to explore connectivity between x and y */
        boolean[] visited = new boolean[adjacentList.length];
        return dfs(adjacentList, x, y, visited);
    }

    private static int dfs(ArrayList<Integer>[] adjacentList, int src, int dest,
                           boolean[] visited) {

        // each vertex is mapped from 1 to n
        if(src == dest) {
            return 1;
        }
        // mark as visited
        visited[src] = true;
        // recursively explore unvisited adjacent vertices
        for(int neighbor : adjacentList[src]) {
            if(!visited[neighbor]) {
                if(dfs(adjacentList, neighbor, dest, visited) == 1) {
                    // reached
                    return 1;
                }
            }
        }
        // not reached
        return 0;
    }
}
