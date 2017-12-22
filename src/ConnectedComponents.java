import java.util.ArrayList;
import java.util.Scanner;

public class ConnectedComponents {

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
        System.out.println(numOfConnectedComponents(adjacentList));
        scanner.close();
    }

    private static int numOfConnectedComponents(ArrayList<Integer>[] adjacentList) {
        // DFS to explore connectivity between x and y */
        boolean[] visited = new boolean[adjacentList.length];
        int result = 1;
        for(int i = 0; i < adjacentList.length; i++) {
            if(!visited[i]) {
                dfs(i, adjacentList, visited);
                result++;
            }
        }
        return result - 1;
    }

    private static int dfs(int vertex, ArrayList<Integer>[] adjacentList,
                           boolean[] visited) {

        // All connected vertices have same count of CC.
        visited[vertex] = true;
        // recursively explore unvisited adjacent vertices
        for(int neighbor : adjacentList[vertex]) {
            if(!visited[neighbor]) {
                dfs(neighbor, adjacentList, visited);
            }
        }
        // not reached
        return 0;
    }
}
